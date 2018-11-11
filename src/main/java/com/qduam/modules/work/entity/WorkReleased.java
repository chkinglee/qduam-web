package com.qduam.modules.work.entity;

import com.qduam.common.persistence.BaseEntity;
import com.qduam.modules.assn.entity.Depart;

/**
 * 已发布工作实体
 * @author lilinzhen
 * @version 2018/4/14
 **/
public class WorkReleased extends BaseEntity {

    private Depart depart;      // 发布部门
    private String logname;     // 工作编号
    private String theme;       // 工作主题
    private String content;     // 工作内容
    private String starttime;   // 开始时间
    private String endtime;     // 结束时间
    private Integer num;        // 已完成人数

    public Depart getDepart() {
        return depart;
    }

    public void setDepart(Depart depart) {
        this.depart = depart;
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
