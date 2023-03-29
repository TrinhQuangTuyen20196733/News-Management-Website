package vn.com.standford.springmvcbasic1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.standford.springmvcbasic1.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity,Long> {
}
