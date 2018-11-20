package com.qduam.modules.sys.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.sys.dao.ProblemDao;
import com.qduam.modules.sys.entity.Problem;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/5/1
 **/
@Service
public class ProblemService extends CrudService<ProblemDao, Problem> {

    @Override
    public Problem get(int id) {
        return super.get(id);
    }

    @Override
    public List<Problem> findList(Problem entity) {
        return super.findList(entity);
    }

    @Override
    public int insert(Problem entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Problem entity) {
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
