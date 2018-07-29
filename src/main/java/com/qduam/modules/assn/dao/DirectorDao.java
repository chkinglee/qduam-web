/**
 * 
 */
package com.qduam.modules.assn.dao;

import java.util.List;

import com.qduam.common.annotation.MybatisDao;
import com.qduam.common.persistence.CrudDao;
import com.qduam.modules.assn.entity.Director;

/**
 * @author lilinzhen
 * @version 2017年8月7日
 */
@MybatisDao
public interface DirectorDao extends CrudDao<Director>{

	@Override
	Director get(int id);

	@Override
	List<Director> findList(Director entity);

	@Override
	List<Director> findAllList(Director entity);

	@Override
	int insert(Director entity);

	@Override
	int update(Director entity);

	@Override
	int delete(int id);
}
