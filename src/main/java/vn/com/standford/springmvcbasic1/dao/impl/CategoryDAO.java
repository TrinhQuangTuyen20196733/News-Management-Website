package vn.com.standford.springmvcbasic1.dao.impl;

import vn.com.standford.springmvcbasic1.dao.ICategoryDAO;
import vn.com.standford.springmvcbasic1.mapper.Categorymapper;
import vn.com.standford.springmvcbasic1.model.CategoryModel;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

    public List<CategoryModel> findAll() {
        String sql = "select * from category";
        return query(sql, new Categorymapper());
    }

    public CategoryModel findone(Long id) {
        String sql = "select * from category where id=?";
        List<CategoryModel> categories = query(sql, new Categorymapper(), id);
        return categories.isEmpty() ? null : categories.get(0);
    }

    public List<CategoryModel> findAlldistincName() {
        String sql = "select id, code,name from category group by name";
        return query(sql, new Categorymapper());
    }

    public CategoryModel findonebyCode(String Code) {
        String sql = "select * from category where code=?";
        List<CategoryModel> categories = query(sql, new Categorymapper(), Code);
        return categories.isEmpty() ? null : categories.get(0);
    }
}
