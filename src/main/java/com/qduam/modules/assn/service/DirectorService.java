package com.qduam.modules.assn.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.assn.dao.DepartDao;
import com.qduam.modules.assn.dao.DirectorDao;
import com.qduam.modules.assn.entity.Director;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/3/18
 **/
@Service
public class DirectorService extends CrudService<DirectorDao, Director>{

    @Resource
    private DirectorDao directorDao;
    @Resource
    private DepartDao departDao;

    @Override
    public Director get(int id) {
        Director director = directorDao.get(id);
        director.setDepart(departDao.get(director.getDepart().getId()));
        return director;
    }

    @Override
    public List<Director> findList(Director entity) {
        List<Director> directorList = directorDao.findList(entity);
        for(int i = 0; i < directorList.size(); i ++){
            directorList.set(i, get(directorList.get(i).getId()));
        }
        return directorList;
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
