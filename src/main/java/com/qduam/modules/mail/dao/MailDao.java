package com.qduam.modules.mail.dao;

import com.qduam.common.annotation.MybatisDao;
import com.qduam.common.persistence.CrudDao;
import com.qduam.modules.mail.entity.Mail;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/4/14
 **/
@MybatisDao
public interface MailDao extends CrudDao<Mail> {

    @Override
    Mail get(int id);

    @Override
    List<Mail> findList(Mail entity);

    @Override
    List<Mail> findAllList(Mail entity);

    @Override
    int insert(Mail entity);

    @Override
    int update(Mail entity);

    @Override
    int delete(int id);
}
