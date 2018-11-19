package com.qduam.modules.assn.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.assn.dao.DirectorDao;
import com.qduam.modules.assn.entity.Director;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/3/18
 **/
@Service
public class DirectorService extends CrudService<DirectorDao, Director>{

    @Override
    public Director get(int id) {
        return super.get(id);
    }

    @Override
    public List<Director> findList(Director entity) {
        return super.findList(entity);
    }

    @Override
    public int insert(Director entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Director entity) {
        return super.update(entity);
    }

    @Override
    public int delete(int id) {
        return super.delete(id);
    }

    @Override
    public int deleteAll(int[] ids) {
        return super.deleteAll(ids);
    }
}
