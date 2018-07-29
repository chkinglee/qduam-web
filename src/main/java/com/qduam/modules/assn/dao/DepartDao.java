/**
 * 
 */
package com.qduam.modules.assn.dao;

import java.util.List;

import com.qduam.common.annotation.MybatisDao;
import com.qduam.common.persistence.CrudDao;
import com.qduam.modules.assn.entity.Depart;

/**
 * @author lilinzhen
 * @version 2017年8月4日
 */
@MybatisDao
public interface DepartDao extends CrudDao<Depart>{


	@Override
	Depart get(int id);

	@Override
	List<Depart> findList(Depart entity);

	@Override
	List<Depart> findAllList(Depart entity);

	@Override
	int insert(Depart entity);

	@Override
	int update(Depart entity);

	@Override
	int delete(int id);

	List<Depart> findListByStu(int id);
}
