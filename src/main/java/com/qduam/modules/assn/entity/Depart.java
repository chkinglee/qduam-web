/**
 * 
 */
package com.qduam.modules.assn.entity;

import java.util.List;

import com.qduam.common.persistence.BaseEntity;
import com.qduam.modules.user.entity.User;

/**
 * 部门实体
 * @author lilinzhen
 * @version 2017年7月26日
 */
public class Depart extends BaseEntity{

	private Assn assn;			// 所属社团
	private User user;			// 对应用户
	private String logname;		// 部门编号、登录账号
	private String depname;		// 部门名称
	private String level;		// 等级
	private String intro;		// 部门简介
	private List<Director> directors;	// 部长团
	private List<Member> members;		// 部员

	public Assn getAssn() {
		return assn;
	}

	public void setAssn(Assn assn) {
		this.assn = assn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
}
