package vn.com.standford.springmvcbasic1.dao;


import vn.com.standford.springmvcbasic1.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO extends IGenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
	List<CategoryModel> findAlldistincName();
	CategoryModel findone(Long id);
	CategoryModel findonebyCode(String Code);
}
