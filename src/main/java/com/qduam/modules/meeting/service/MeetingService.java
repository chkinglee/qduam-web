package com.qduam.modules.meeting.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.assn.dao.DepartDao;
import com.qduam.modules.assn.dao.MemberDao;
import com.qduam.modules.assn.entity.Member;
import com.qduam.modules.meeting.dao.MeetingDao;
import com.qduam.modules.meeting.entity.Meeting;
import com.qduam.modules.student.dao.StudentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MeetingService extends CrudService<MeetingDao, Meeting> {

    @Resource
    private MeetingDao meetingDao;
    @Resource
    private DepartDao departDao;
    @Resource
    private MemberDao memberDao;
    @Resource
    private StudentDao studentDao;

    @Override
    public Meeting get(int id) {
        Meeting meeting = meetingDao.get(id);

        meeting.setDepart(departDao.get(meeting.getDepart().getId()));

        Member member = memberDao.get(meeting.getMember().getId());
        member.setStudent(studentDao.get(member.getStudent().getId()));
        meeting.setMember(member);

        return meeting;
    }

    @Override
    public List<Meeting> findList(Meeting entity) {
        List<Meeting> meetingList = meetingDao.findList(entity);
        for(int i = 0; i < meetingList.size(); i ++) {
            meetingList.set(i, get(meetingList.get(i).getId()));
        }
        return meetingList;
    }

    @Override
    public int insert(Meeting entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Meeting entity) {
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
