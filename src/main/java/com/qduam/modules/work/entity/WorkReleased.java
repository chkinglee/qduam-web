package com.qduam.modules.work.entity;

import com.qduam.common.persistence.BaseEntity;
import com.qduam.modules.assn.entity.Depart;

/**
 * @author lilinzhen
 * @version 2018/4/14
 **/
public class WorkReleased extends BaseEntity {

    private Depart depart;
    private String logname;
    private String theme;
    private String content;
    private String starttime;
    private String endtime;
    private Integer num;

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
