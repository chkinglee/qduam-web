/**
 * 
 */
package com.qduam.modules.assn.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.assn.dao.DepartDao;
import com.qduam.modules.assn.entity.Depart;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lilinzhen
 * @version 2017年8月8日
 */
@Service
public class DepartService extends CrudService<DepartDao, Depart>{

	@Resource
	private DepartDao departdao;

	@Override
	public Depart get(int id) {
		return super.get(id);
	}

	@Override
	public List<Depart> findList(Depart entity) {
		return super.findList(entity);
	}

    public List<Depart> findListByStu(int id) {
		return departdao.findListByStu(id);
	}

	@Override
	public int insert(Depart entity) {
		return super.insert(entity);
	}

	@Override
	public int update(Depart entity) {
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
