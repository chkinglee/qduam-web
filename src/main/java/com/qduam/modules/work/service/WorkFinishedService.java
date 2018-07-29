package com.qduam.modules.work.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.assn.service.MemberService;
import com.qduam.modules.work.dao.WorkFinishedDao;
import com.qduam.modules.work.entity.WorkFinished;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/4/14
 **/
public class WorkFinishedService extends CrudService<WorkFinishedDao, WorkFinished> {

    @Resource
    private WorkFinishedDao workFinishedDao;
    @Resource
    private MemberService memberService;
    @Resource
    private WorkReleasedService workReleasedService;



    @Override
    public WorkFinished get(int id) {
        WorkFinished workFinished = workFinishedDao.get(id);

        workFinished.setMember(memberService.get(workFinished.getMember().getId()));
        workFinished.setWorkReleased(workReleasedService.get(workFinished.getWorkReleased().getId()));

        return workFinished;
    }

    @Override
    public List<WorkFinished> findList(WorkFinished entity) {
        List<WorkFinished> workFinishedList = workFinishedDao.findList(entity);
        for(int i = 0; i < workFinishedList.size(); i ++) {
            workFinishedList.set(i, get(workFinishedList.get(i).getId()));
        }
        return workFinishedList;
    }

    @Override
    public int insert(WorkFinished entity) {
        return super.insert(entity);
    }

    @Override
    public int update(WorkFinished entity) {
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
