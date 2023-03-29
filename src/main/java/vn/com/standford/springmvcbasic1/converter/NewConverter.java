package vn.com.standford.springmvcbasic1.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.com.standford.springmvcbasic1.dto.NewDTO;
import vn.com.standford.springmvcbasic1.entity.NewEntity;
import vn.com.standford.springmvcbasic1.repository.CategoryRepository;

@Component
public class NewConverter {
    @Autowired
    private CategoryRepository categoryRepository;
    public NewDTO toDto(NewEntity newEntity) {
        NewDTO result = new NewDTO();
        result.setId(newEntity.getId());
        result.setTitle(newEntity.getTitle());
        result.setShortdescription(newEntity.getShortdescription());
        result.setContent(newEntity.getContent());
        result.setThumbnail(newEntity.getThumbnail());
        result.setCategoryCode(newEntity.getCategory().getCode());
        return result;
    }
    public  NewEntity toEntity(NewDTO newDTO){

        NewEntity result = new NewEntity();
        result.setTitle(newDTO.getTitle());
        result.setShortdescription(newDTO.getShortdescription());
        result.setContent(newDTO.getContent());
        result.setThumbnail(newDTO.getThumbnail());
        result.setCategory(categoryRepository.findOneByCode(newDTO.getCategoryCode()));
        return result;
    }
    public  NewEntity toEntity(NewEntity result,NewDTO newDTO){
        result.setTitle(newDTO.getTitle());
        result.setShortdescription(newDTO.getShortdescription());
        result.setContent(newDTO.getContent());
        result.setThumbnail(newDTO.getThumbnail());
        result.setCategory(categoryRepository.findOneByCode(newDTO.getCategoryCode()));
        return result;
    }
}
