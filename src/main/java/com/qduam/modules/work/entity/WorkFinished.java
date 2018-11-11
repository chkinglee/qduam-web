package com.qduam.modules.work.entity;

import com.qduam.common.persistence.BaseEntity;
import com.qduam.modules.assn.entity.Depart;
import com.qduam.modules.assn.entity.Member;

/**
 * 已完成工作实体
 * @author lilinzhen
 * @version 2018/4/14
 **/
public class WorkFinished extends BaseEntity {

    private Member member;              // 部员
    private WorkReleased workReleased;  // 已发布工作
    private String result;              // 结果
    private String status;              // 状态
    private String appraise;            // 评价

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
