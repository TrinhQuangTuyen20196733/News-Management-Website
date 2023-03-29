package vn.com.standford.springmvcbasic1.dao.impl;

import org.springframework.stereotype.Repository;
import vn.com.standford.springmvcbasic1.dao.INewDAO;
import vn.com.standford.springmvcbasic1.mapper.Newmapper;
import vn.com.standford.springmvcbasic1.model.NewModel;

import java.util.List;

@Repository
public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {


    public List<NewModel> findAll() {
        String sql = "select * from news";
        return query(sql, new Newmapper());
    }


}
