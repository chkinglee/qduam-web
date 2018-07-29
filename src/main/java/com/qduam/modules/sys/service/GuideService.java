package com.qduam.modules.sys.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.sys.dao.GuideDao;
import com.qduam.modules.sys.entity.Guide;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/4/30
 **/
@Service
public class GuideService extends CrudService<GuideDao, Guide> {

    @Override
    public Guide get(int id) {
        return super.get(id);
    }

    @Override
    public List<Guide> findList(Guide entity) {
        return super.findList(entity);
    }

    @Override
    public int insert(Guide entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Guide entity) {
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
