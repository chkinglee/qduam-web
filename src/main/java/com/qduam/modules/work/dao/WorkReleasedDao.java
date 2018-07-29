package com.qduam.modules.work.dao;

import com.qduam.common.annotation.MybatisDao;
import com.qduam.common.persistence.CrudDao;
import com.qduam.modules.work.entity.WorkReleased;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/4/14
 **/
@MybatisDao
public interface WorkReleasedDao extends CrudDao<WorkReleased> {

    @Override
    WorkReleased get(int id);

    @Override
    List<WorkReleased> findList(WorkReleased entity);

    @Override
    List<WorkReleased> findAllList(WorkReleased entity);

    @Override
    int insert(WorkReleased entity);

    @Override
    int update(WorkReleased entity);

    @Override
    int delete(int id);
}
