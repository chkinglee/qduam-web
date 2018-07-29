/**
 * 
 */
package com.qduam.modules.student.entity;

import com.qduam.common.persistence.BaseEntity;
import com.qduam.modules.assn.entity.Member;
import com.qduam.modules.enroll.entity.Enroll;
import com.qduam.modules.user.entity.User;

import java.util.List;

/**
 * 学生实体
 * @author lilinzhen
 * @version 2017年7月17日
 */
public class Student extends BaseEntity{

	private String logname;		// 学号
	private String name;		// 姓名
	private String sex;			// 性别
	private String birthday;	// 出生日期
	private String nation;		// 民族
	private String grade;		// 年级
	private String department;  // 所在学院
	private String major;		// 专业
	private String phone;		// 手机号码
	private String qqnumber;	// QQ号
	private String dorm;		// 宿舍号
	private User user;
	private List<Enroll> enrolls;		// 报名信息
	private List<Member> members;		// 已加入成员信息
	private Integer friendsnum;

	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQqnumber() {
		return qqnumber;
	}

	public void setQqnumber(String qqnumber) {
		this.qqnumber = qqnumber;
	}

	public String getDorm() {
		return dorm;
	}

	public void setDorm(String dorm) {
		this.dorm = dorm;
	}

	public List<Enroll> getEnrolls() {
		return enrolls;
	}

	public void setEnrolls(List<Enroll> enrolls) {
		this.enrolls = enrolls;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getFriendsnum() {
		return friendsnum;
	}

	public void setFriendsnum(Integer friendsnum) {
		this.friendsnum = friendsnum;
	}
}
