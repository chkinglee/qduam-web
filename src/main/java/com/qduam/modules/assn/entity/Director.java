/**
 * 
 */
package com.qduam.modules.assn.entity;

import com.qduam.common.persistence.BaseEntity;

/**
 * @author lilinzhen
 * @version 2017年8月7日
 */
public class Director extends BaseEntity{
	
	private Depart depart;	// 所属部门
	private String name;	// 部长姓名
	private String phone;	// 联系方式
	private String level;	// 职务
	private String sex;	// 性别

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
