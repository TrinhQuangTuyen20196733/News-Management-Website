package vn.com.standford.springmvcbasic1.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
 T mapRow(ResultSet rs);
}
