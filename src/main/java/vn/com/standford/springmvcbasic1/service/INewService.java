package vn.com.standford.springmvcbasic1.service;

import org.springframework.data.domain.Pageable;
import vn.com.standford.springmvcbasic1.dto.NewDTO;
import vn.com.standford.springmvcbasic1.model.NewModel;

import java.util.List;

public interface INewService {
    List<NewDTO> findAll(Pageable pageable);
    int getTotalItem();
    NewDTO findById(Long id);
    NewDTO save(NewDTO newDTO);
    void delete(Long[] ids);

}

