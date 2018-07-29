package com.qduam.modules.work.entity;

import com.qduam.common.persistence.BaseEntity;
import com.qduam.modules.assn.entity.Depart;
import com.qduam.modules.assn.entity.Member;

/**
 * @author lilinzhen
 * @version 2018/4/14
 **/
public class WorkFinished extends BaseEntity {

    private Member member;
    private WorkReleased workReleased;
    private String result;
    private String status;
    private String appraise;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public WorkReleased getWorkReleased() {
        return workReleased;
    }

    public void setWorkReleased(WorkReleased workReleased) {
        this.workReleased = workReleased;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppraise() {
        return appraise;
    }

    public void setAppraise(String appraise) {
        this.appraise = appraise;
    }
}
