package com.qduam.modules.work.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.assn.service.DepartService;
import com.qduam.modules.work.dao.WorkReleasedDao;
import com.qduam.modules.work.entity.WorkReleased;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/4/14
 **/
@Service
public class WorkReleasedService extends CrudService<WorkReleasedDao, WorkReleased> {

    @Resource
    WorkReleasedDao workReleasedDao;
    @Resource
    DepartService departService;

    @Override
    public WorkReleased get(int id) {
        WorkReleased workReleased = workReleasedDao.get(id);

        workReleased.setDepart(departService.get(workReleased.getDepart().getId()));

        return workReleased;
    }

    @Override
    public List<WorkReleased> findList(WorkReleased entity) {
        List<WorkReleased> workReleasedList = workReleasedDao.findList(entity);
        for(int i = 0; i < workReleasedList.size(); i ++) {
            workReleasedList.set(i, get(workReleasedList.get(i).getId()));
        }
        return workReleasedList;
    }

    @Override
    public int insert(WorkReleased entity) {
        return super.insert(entity);
    }

    @Override
    public int update(WorkReleased entity) {
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
