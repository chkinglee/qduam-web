/**
 * 
 */
package com.qduam.modules.sys.dao;

import java.util.List;

import com.qduam.common.annotation.MybatisDao;
import com.qduam.common.persistence.CrudDao;
import com.qduam.modules.sys.entity.Dict;


/**
 * 字典DAO接口
 * @author yyy
 * @version 2014-05-16
 */
@MybatisDao
public interface DictDao extends CrudDao<Dict> {

    @Override
    Dict get(int id);

    @Override
    List<Dict> findList(Dict entity);

    @Override
    List<Dict> findAllList(Dict entity);

    @Override
    int insert(Dict entity);

    @Override
    int update(Dict entity);

    @Override
    int delete(int id);
}
    
