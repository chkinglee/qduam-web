/**
 * 
 */
package com.qduam.modules.enroll.dao;

import java.util.List;

import com.qduam.common.annotation.MybatisDao;
import com.qduam.common.persistence.CrudDao;
import com.qduam.modules.enroll.entity.Enroll;

/**
 * @author lilinzhen
 * @version 2017年8月2日
 */
@MybatisDao
public interface EnrollDao extends CrudDao<Enroll> {

	@Override
	Enroll get(int id);

	@Override
	List<Enroll> findList(Enroll entity);

	@Override
	List<Enroll> findAllList(Enroll entity);

	@Override
	int insert(Enroll entity);

	@Override
	int update(Enroll entity);

	@Override
	int delete(int id);
}
