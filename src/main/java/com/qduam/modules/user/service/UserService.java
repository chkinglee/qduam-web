package com.qduam.modules.user.service;

import com.qduam.common.persistence.CrudService;
import com.qduam.modules.user.dao.UserDao;
import com.qduam.modules.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/3/25
 **/
@Service
public class UserService extends CrudService<UserDao, User>{

    @Autowired
    UserDao userDao;

    @Override
    public User get(int id) {
        return super.get(id);
    }

    @Override
    public List<User> findList(User entity) {
        return super.findList(entity);
    }

    @Override
    public int insert(User entity) {
        return super.insert(entity);
    }

    @Override
    public int update(User entity) {
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
