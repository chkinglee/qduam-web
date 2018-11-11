package com.qduam.modules.sys.entity;

import com.qduam.common.persistence.BaseEntity;

/**
 * 操作指南实体
 * @author lilinzhen
 * @version 2018/4/30
 **/
public class Guide extends BaseEntity {

    private String question;    // 问题
    private String answer;      // 答案

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
