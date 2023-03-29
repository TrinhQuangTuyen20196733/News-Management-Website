package vn.com.standford.springmvcbasic1.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.standford.springmvcbasic1.converter.NewConverter;
import vn.com.standford.springmvcbasic1.dto.NewDTO;
import vn.com.standford.springmvcbasic1.entity.CategoryEntity;
import vn.com.standford.springmvcbasic1.entity.NewEntity;
import vn.com.standford.springmvcbasic1.repository.CategoryRepository;
import vn.com.standford.springmvcbasic1.repository.NewRepository;
import vn.com.standford.springmvcbasic1.service.INewService;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewService implements INewService {
    //
    @Autowired
    private NewRepository newRepository;
    @Autowired
    private NewConverter newConverter;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<NewDTO> findAll(Pageable pageable) {
        List<NewDTO> model = new ArrayList<NewDTO>();
        List<NewEntity> newEntity = newRepository.findAll(pageable).getContent();
        newEntity.forEach(items -> model.add(newConverter.toDto(items)));
        return model;

    }

    @Override
    public int getTotalItem() {
        return (int) newRepository.count();
    }

    @Override
    public NewDTO findById(Long id) {
        NewEntity newEntity = newRepository.findOne(id);
        return newConverter.toDto(newEntity);

    }


    @Override
    @Transactional
    public NewDTO save(NewDTO newDTO) {
        NewEntity newEntity = new NewEntity();
        if (newDTO.getId() != null) {
            NewEntity oldNew = newRepository.findOne(newDTO.getId());
            newEntity = newConverter.toEntity(oldNew, newDTO);
        } else {
            newEntity = newConverter.toEntity(newDTO);
        }
        return newConverter.toDto(newRepository.save(newEntity));
    }

    @Override
    @Transactional
    public void delete(Long[] ids) {
    for (Long id:ids){
        newRepository.delete(id);
    }
    }
}

