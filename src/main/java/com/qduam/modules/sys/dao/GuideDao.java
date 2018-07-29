package com.qduam.modules.sys.dao;

import com.qduam.common.annotation.MybatisDao;
import com.qduam.common.persistence.CrudDao;
import com.qduam.modules.sys.entity.Guide;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/4/30
 **/
@MybatisDao
public interface GuideDao extends CrudDao<Guide> {
    @Override
    Guide get(int id);

    @Override
    List<Guide> findList(Guide entity);

    @Override
    List<Guide> findAllList(Guide entity);

    @Override
    int insert(Guide entity);

    @Override
    int update(Guide entity);

    @Override
    int delete(int id);
}
