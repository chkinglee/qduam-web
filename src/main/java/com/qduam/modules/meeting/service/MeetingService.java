package com.qduam.modules.meeting.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.meeting.dao.MeetingDao;
import com.qduam.modules.meeting.entity.Meeting;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService extends CrudService<MeetingDao, Meeting> {

    @Override
    public Meeting get(int id) {
        return super.get(id);
    }

    @Override
    public List<Meeting> findList(Meeting entity) {
        return super.findList(entity);
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
