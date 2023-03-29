package vn.com.standford.springmvcbasic1.dao;

import vn.com.standford.springmvcbasic1.mapper.RowMapper;

import java.util.List;

public interface IGenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowmapper, Object... Parameter);
	void update(String sql,Object... Parameter );
	Long insert(String sql,Object...Parameter);
	int count(String sql,Object...Parameter);
}
