package vn.com.standford.springmvcbasic1.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import vn.com.standford.springmvcbasic1.model.NewModel;

public interface INewDAO extends IGenericDAO<NewModel> {
	
	List<NewModel> findAll();

}
