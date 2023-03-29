package vn.com.standford.springmvcbasic1.mapper;

import vn.com.standford.springmvcbasic1.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Categorymapper implements RowMapper<CategoryModel> {


    public CategoryModel mapRow(ResultSet rs) {
        CategoryModel categoryModel = new CategoryModel();
        try {
            categoryModel.setId(rs.getLong("id"));
            categoryModel.setCode(rs.getString("code"));
            categoryModel.setName(rs.getString("name"));
        } catch (SQLException e) {
            return null;
        }
        return categoryModel;
    }

}
