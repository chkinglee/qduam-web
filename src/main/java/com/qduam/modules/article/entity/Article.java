package com.qduam.modules.article.entity;

import com.qduam.common.persistence.BaseEntity;
import com.qduam.modules.user.entity.User;

/**
 * 文章实体
 * @author lilinzhen
 * @version 2017年7月17日
 */
public class Article extends BaseEntity{

	private String title;		// 题目
	private String content;		// 内容
	private User user;			// 作者
	private String time;		// 发表时间
	private String sectionA;	// 一级版块
	private String sectionB;	// 二级板块

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSectionA() {
		return sectionA;
	}

	public void setSectionA(String sectionA) {
		this.sectionA = sectionA;
	}

	public String getSectionB() {
		return sectionB;
	}

	public void setSectionB(String sectionB) {
		this.sectionB = sectionB;
	}
}
