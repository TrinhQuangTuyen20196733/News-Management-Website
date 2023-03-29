package vn.com.standford.springmvcbasic1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.standford.springmvcbasic1.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findOneByUserNameAndStatus(String name, int status);
}
