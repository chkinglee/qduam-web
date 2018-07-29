/**
 * 
 */
package com.qduam.modules.assn.service;

import javax.annotation.Resource;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.assn.entity.Assn;
import com.qduam.modules.assn.entity.Depart;
import org.springframework.stereotype.Service;

import com.qduam.modules.assn.dao.AssnDao;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2017年7月18日
 */
@Service
public class AssnService extends CrudService<AssnDao, Assn>{

	 @Resource
	 private AssnDao assnDao;
	 @Resource
	 private DepartService departService;

	@Override
	public Assn get(int id) {
		Assn assn = assnDao.get(id);

		Depart depart = new Depart();
		depart.setAssn(assn);
		List<Depart> departList = departService.findList(depart);
		assn.setDeparts(departList);

		Integer membercount = 0;
		for(Depart d : departList) {
			membercount += d.getMembers().size();
		}
		assn.setMembercount(membercount);

		return assn;
	}

	@Override
	public List<Assn> findList(Assn entity) {
		List<Assn> assnList = assnDao.findList(entity);
		for(int i = 0; i < assnList.size(); i ++){
			assnList.set(i, get(assnList.get(i).getId()));
		}
		return assnList;
	}

	public List<Assn> findListByStu(int id) {
		List<Assn> assnList = assnDao.findListByStu(id);
		for(int i = 0; i < assnList.size(); i ++){
			assnList.set(i, get(assnList.get(i).getId()));
		}
		return assnList;
	}

	@Override
	public int insert(Assn entity) {
		return super.insert(entity);
	}

	@Override
	public int update(Assn entity) {
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
