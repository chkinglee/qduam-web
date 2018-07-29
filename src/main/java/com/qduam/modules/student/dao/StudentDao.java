/**
 * 
 */
package com.qduam.modules.student.dao;

import java.util.List;

import com.qduam.common.persistence.CrudDao;
import org.apache.ibatis.annotations.Param;

import com.qduam.common.annotation.MybatisDao;
import com.qduam.modules.student.entity.Student;

/**
 * @author lilinzhen
 * @version 2017年7月31日
 */
@MybatisDao
public interface StudentDao extends CrudDao<Student> {

	@Override
	Student get(int id);

	@Override
	List<Student> findList(Student entity);

	@Override
	List<Student> findAllList(Student entity);

	@Override
	int insert(Student entity);

	@Override
	int update(Student entity);

	@Override
	int delete(int id);
}
