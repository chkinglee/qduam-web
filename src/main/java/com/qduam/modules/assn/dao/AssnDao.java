/**
 * 
 */
package com.qduam.modules.assn.dao;

import java.util.List;

import com.qduam.common.annotation.MybatisDao;
import com.qduam.common.persistence.CrudDao;
import com.qduam.modules.assn.entity.Assn;

/**
 * @author lilinzhen
 * @version 2017年7月18日
 */
@MybatisDao
public interface AssnDao extends CrudDao<Assn>{

    @Override
    Assn get(int id);

    @Override
    List<Assn> findList(Assn entity);

    @Override
    List<Assn> findAllList(Assn entity);

    @Override
    int insert(Assn entity);

    @Override
    int update(Assn entity);

    @Override
    int delete(int id);

    List<Assn> findListByStu(int id);
}
