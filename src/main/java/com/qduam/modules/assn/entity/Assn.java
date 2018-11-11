/**
 * 
 */
package com.qduam.modules.assn.entity;

import java.util.List;

import com.qduam.common.persistence.BaseEntity;

/**
 * 社团实体
 * @author lilinzhen
 * @version 2017年7月18日
 */
public class Assn extends BaseEntity{

	private String logname;			// 社团账号
	private String assnname;		// 社团名称
	private String director;		// 社团负责人
	private String phone;			// 社团负责人联系方式
	private String level;			// 社团级别
	private List<Depart> departs;	// 部门
	private Integer membercount;	// 部员数量

	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<Depart> getDeparts() {
		return departs;
	}

	public void setDeparts(List<Depart> departs) {
		this.departs = departs;
	}

	public String getAssnname() {
		return assnname;
	}

	public void setAssnname(String assnname) {
		this.assnname = assnname;
	}

	public Integer getMembercount() {
		return membercount;
	}

	public void setMembercount(Integer membercount) {
		this.membercount = membercount;
	}
}
