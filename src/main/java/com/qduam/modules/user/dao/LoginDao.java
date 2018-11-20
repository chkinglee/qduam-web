package com.qduam.modules.user.dao;


import com.qduam.common.annotation.MybatisDao;
import com.qduam.common.persistence.CrudDao;
import com.qduam.modules.assn.entity.Depart;
import com.qduam.modules.student.entity.Student;
import com.qduam.modules.user.entity.User;
import org.apache.ibatis.annotations.Param;

@MybatisDao
public interface LoginDao extends CrudDao<User> {

    /*
    获得登陆者信息
     */
    User get(User user);

    /**
     * 修改密码
     */
    int updatePs(@Param("logname") String logname, @Param("password") String password);
}
