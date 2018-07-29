package com.qduam.modules.sys.entity;

import com.qduam.common.persistence.BaseEntity;
import com.qduam.modules.user.entity.User;

/**
 * @author lilinzhen
 * @version 2018/4/30
 **/
public class Problem extends BaseEntity {

    private User user;
    private String content;

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
