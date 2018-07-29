package com.qduam.modules.mail.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.mail.dao.MailDao;
import com.qduam.modules.mail.entity.Mail;
import com.qduam.modules.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/4/14
 **/
@Service
public class MailService extends CrudService<MailDao, Mail> {

    @Resource
    MailDao mailDao;
    @Resource
    UserService userService;

    @Override
    public Mail get(int id) {
        Mail mail = mailDao.get(id);

        mail.setSender(userService.get(mail.getSender().getId()));
        mail.setReceiver(userService.get(mail.getReceiver().getId()));

        return mail;
    }

    @Override
    public List<Mail> findList(Mail entity) {
        List<Mail> mailList = mailDao.findList(entity);
        for(int i = 0; i < mailList.size(); i ++) {
            mailList.set(i, get(mailList.get(i).getId()));
        }
        return mailList;
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
