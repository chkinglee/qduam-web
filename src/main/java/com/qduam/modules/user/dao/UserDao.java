package com.qduam.modules.user.dao;

import com.qduam.common.annotation.MybatisDao;
import com.qduam.common.persistence.CrudDao;
import com.qduam.modules.user.entity.User;

import java.util.List;

/**
 * @author lilinzhen
 * @version 2018/3/25
 **/
@MybatisDao
public interface UserDao extends CrudDao<User> {

    @Override
    User get(int id);

    @Override
    List<User> findList(User entity);

    @Override
    List<User> findAllList(User entity);

    @Override
    int insert(User entity);

    @Override
    int update(User entity);

    @Override
    int delete(int id);
}
