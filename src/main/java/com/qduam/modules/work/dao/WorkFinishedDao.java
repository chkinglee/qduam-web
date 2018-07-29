package com.qduam.modules.work.dao;

import com.qduam.common.annotation.MybatisDao;
import com.qduam.common.persistence.CrudDao;
import com.qduam.modules.work.entity.WorkFinished;
import com.qduam.modules.work.entity.WorkReleased;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/4/14
 **/
@MybatisDao
public interface WorkFinishedDao extends CrudDao<WorkFinished> {

    @Override
    WorkFinished get(int id);

    @Override
    List<WorkFinished> findList(WorkFinished entity);

    @Override
    List<WorkFinished> findAllList(WorkFinished entity);

    @Override
    int insert(WorkFinished entity);

    @Override
    int update(WorkFinished entity);

    @Override
    int delete(int id);
}
