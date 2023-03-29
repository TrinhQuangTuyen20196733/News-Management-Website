package vn.com.standford.springmvcbasic1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {

    public List<UserEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<UserEntity> posts) {
        this.posts = posts;
    }

    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> posts = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
