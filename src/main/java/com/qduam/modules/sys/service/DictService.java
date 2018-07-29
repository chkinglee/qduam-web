package com.qduam.modules.sys.service;

import java.util.List;
import javax.annotation.Resource;

import com.qduam.common.persistence.CrudService;
import org.springframework.stereotype.Service;

import com.qduam.modules.sys.dao.DictDao;
import com.qduam.modules.sys.entity.Dict;


/**
 * 字典Service
 * @author yyy
 * @version 2014-05-16
 */
@Service
public class DictService extends CrudService<DictDao,Dict>{


    @Override
    public Dict get(int id) {
        return super.get(id);
    }

    @Override
    public List<Dict> findList(Dict entity) {
        return super.findList(entity);
    }

    @Override
    public int insert(Dict entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Dict entity) {
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
