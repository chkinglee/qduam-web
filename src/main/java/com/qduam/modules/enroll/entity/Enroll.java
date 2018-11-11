/**
 * 
 */
package com.qduam.modules.enroll.entity;

import com.qduam.common.persistence.BaseEntity;
import com.qduam.modules.assn.entity.Depart;
import com.qduam.modules.student.entity.Student;

/**
 * 报名表实体
 * @author lilinzhen
 * @version 2017年8月2日
 */
public class Enroll extends BaseEntity {
	
	private Student student;	//学生id
	private Depart depart;		//部门id
	private String charact;		//特长
	private String intro;		//自我介绍
	private String wgive;		//期望付出
	private String wgain;		//期望收货
	private String status;		//报名状态


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

	public String getCharact() {
		return charact;
	}

	public void setCharact(String charact) {
		this.charact = charact;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getWgive() {
		return wgive;
	}

	public void setWgive(String wgive) {
		this.wgive = wgive;
	}

	public String getWgain() {
		return wgain;
	}

	public void setWgain(String wgain) {
		this.wgain = wgain;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
