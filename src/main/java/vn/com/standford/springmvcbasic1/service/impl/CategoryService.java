package vn.com.standford.springmvcbasic1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.standford.springmvcbasic1.converter.CategoryConverter;
import vn.com.standford.springmvcbasic1.dto.CategoryDTO;
import vn.com.standford.springmvcbasic1.entity.CategoryEntity;
import vn.com.standford.springmvcbasic1.repository.CategoryRepository;
import vn.com.standford.springmvcbasic1.service.ICategoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public Map<String,String> findAll() {
        Map<String,String> result = new HashMap<>();
        List<CategoryDTO> categoryDTOS = new ArrayList<CategoryDTO>();
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
       /* for (CategoryEntity categoryEntity: categoryEntities){
            categoryDTOS.add(categoryConverter.toDto(categoryEntity));
        }*/
        categoryEntities.forEach(categoryEntity -> result.put(categoryEntity.getCode(),categoryEntity.getName()));
        return result;
    }
}
