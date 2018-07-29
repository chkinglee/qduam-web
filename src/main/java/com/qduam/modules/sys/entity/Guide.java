package com.qduam.modules.sys.entity;

import com.qduam.common.persistence.BaseEntity;

/**
 * @author lilinzhen
 * @version 2018/4/30
 **/
public class Guide extends BaseEntity {

    private String question;
    private String answer;

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
