package com.qduam.modules.mail.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.mail.dao.MailDao;
import com.qduam.modules.mail.entity.Mail;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/4/14
 **/
@Service
public class MailService extends CrudService<MailDao, Mail> {

    @Override
    public Mail get(int id) {
        return super.get(id);
    }

    @Override
    public List<Mail> findList(Mail entity) {
        return super.findList(entity);
    }

    @Override
    public int insert(Mail entity) {
        return super.insert(entity);
    }

    @Override
    public int update(Mail entity) {
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
