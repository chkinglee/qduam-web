package com.qduam.modules.meeting.dao;

import com.qduam.common.annotation.MybatisDao;
import com.qduam.common.persistence.CrudDao;
import com.qduam.modules.meeting.entity.Meeting;

import java.util.List;

/**
 * 会议DAO
 * @author lilinzhen
 * @version 2018年4月28日
 */
@MybatisDao
public interface MeetingDao extends CrudDao<Meeting> {

    @Override
    Meeting get(int id);

    @Override
    List<Meeting> findList(Meeting entity);

    @Override
    List<Meeting> findAllList(Meeting entity);

    @Override
    int insert(Meeting entity);

    @Override
    int update(Meeting entity);

    @Override
    int delete(int id);
}
