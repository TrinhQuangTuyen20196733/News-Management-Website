package vn.com.standford.springmvcbasic1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.standford.springmvcbasic1.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    CategoryEntity findOneByCode(String code);
}
