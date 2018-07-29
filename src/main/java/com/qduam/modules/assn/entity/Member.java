package com.qduam.modules.assn.entity;

import com.qduam.common.persistence.BaseEntity;
import com.qduam.modules.student.entity.Student;

/**
 * @author lilinzhen
 * @version 2018/3/14
 **/
public class Member extends BaseEntity{

    private Student student;    // 对应学生
    private Depart depart;      // 所属部门
    private String appraise;    // 评价
    private String status;      // 状态

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Depart getDepart() {
        return depart;
    }

    public void setDepart(Depart depart) {
        this.depart = depart;
    }

    public String getAppraise() {
        return appraise;
    }

    public void setAppraise(String appraise) {
        this.appraise = appraise;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
