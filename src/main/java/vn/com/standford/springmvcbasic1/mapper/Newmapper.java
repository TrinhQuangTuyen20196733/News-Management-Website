package vn.com.standford.springmvcbasic1.mapper;

import vn.com.standford.springmvcbasic1.model.NewModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Newmapper implements RowMapper<NewModel> {

    public NewModel mapRow(ResultSet rs) {
        NewModel news = new NewModel();
        try {
            news.setId(rs.getLong("id"));
            news.setTitle(rs.getString("title"));
            news.setContent(rs.getString("content"));
            news.setCategoryId(rs.getLong("categoryid"));
            news.setThumbnail(rs.getString("thumbnail"));
            news.setShortdescription(rs.getString("shortdescription"));

            news.setCreatedDate(rs.getTimestamp("createddate"));
            news.setCreatedby(rs.getString("createdby"));
            if (rs.getTimestamp("modifieddate") != null) {
                news.setModifiedDate(rs.getTimestamp("modifieddate"));
            }
            if (rs.getString("modifiedby") != null) {
                news.setModifiedby(rs.getString("modifiedby"));
            }
        } catch (SQLException e) {
            return null;
        }

        return news;
    }

}
