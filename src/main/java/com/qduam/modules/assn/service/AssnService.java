/**
 * 
 */
package com.qduam.modules.assn.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.assn.dao.AssnDao;
import com.qduam.modules.assn.entity.Assn;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lilinzhen
 * @version 2017年7月18日
 */
@Service
public class  AssnService extends CrudService<AssnDao, Assn>{

    @Resource
    private AssnDao assnDao;

	@Override
	public Assn get(int id) {
		return super.get(id);
	}

	@Override
	public List<Assn> findList(Assn entity) {
		return super.findList(entity);
	}

	public List<Assn> findListByStu(int id) {
		return assnDao.findListByStu(id);
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
