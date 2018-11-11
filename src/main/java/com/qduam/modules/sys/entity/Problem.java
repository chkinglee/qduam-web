package com.qduam.modules.sys.entity;

import com.qduam.common.persistence.BaseEntity;
import com.qduam.modules.user.entity.User;

/**
 * 问题反馈实体
 * @author lilinzhen
 * @version 2018/4/30
 **/
public class Problem extends BaseEntity {

    private User user;      // 反馈用户
    private String content; // 问题描述

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
