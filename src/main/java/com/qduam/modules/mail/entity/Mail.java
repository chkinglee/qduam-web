package com.qduam.modules.mail.entity;

import com.qduam.common.persistence.BaseEntity;
import com.qduam.modules.user.entity.User;

/**
 * @author lilinzhen
 * @version 2018/4/14
 **/
public class Mail extends BaseEntity {

    private User sender;    // 发件人
    private User receiver;  // 收件人
    private String time;    // 发送时间
    private String content; // 内容
    private String theme;   // 主题


    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
