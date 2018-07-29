package com.qduam.modules.sys.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.sys.dao.ProblemDao;
import com.qduam.modules.sys.entity.Problem;
import com.qduam.modules.user.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/5/1
 **/
@Service
public class ProblemService extends CrudService<ProblemDao, Problem> {

    @Resource
    private ProblemDao problemDao;
    @Resource
    private UserDao userDao;

    @Override
    public Problem get(int id) {
        Problem problem = problemDao.get(id);
        problem.setUser(userDao.get(problem.getUser().getId()));
        return problem;
    }

    @Override
    public List<Problem> findList(Problem entity) {
        List<Problem> problemList = problemDao.findList(entity);
        for(int i = 0; i < problemList.size(); i ++) {
            problemList.set(i, get(problemList.get(i).getId()));
        }
        return problemList;
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
