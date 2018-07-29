package com.qduam.modules.sys.dao;

import com.qduam.common.annotation.MybatisDao;
import com.qduam.common.persistence.CrudDao;
import com.qduam.modules.sys.entity.Problem;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/4/30
 **/
@MybatisDao
public interface ProblemDao extends CrudDao<Problem> {

    @Override
    Problem get(int id);

    @Override
    List<Problem> findList(Problem entity);

    @Override
    List<Problem> findAllList(Problem entity);

    @Override
    int insert(Problem entity);

    @Override
    int update(Problem entity);

    @Override
    int delete(int id);
}
