/**
 * 
 */
package com.qduam.modules.enroll.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.enroll.dao.EnrollDao;
import com.qduam.modules.enroll.entity.Enroll;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author lilinzhen
 * @version 2017年8月2日
 */
@Service
public class EnrollService extends CrudService<EnrollDao, Enroll> {


	@Override
	public Enroll get(int id) {
		return super.get(id);
	}

	@Override
	public List<Enroll> findList(Enroll entity) {
		return super.findList(entity);
	}

	@Override
	public int insert(Enroll entity) {
		return super.insert(entity);
	}

	@Override
	public int update(Enroll entity) {
		return super.update(entity);
	}

	@Override
	public int delete(int id) {
		return super.delete(id);
	}

	@Override
	public int deleteAll(int[] ids) {
		return super.deleteAll(ids);
	}
}
