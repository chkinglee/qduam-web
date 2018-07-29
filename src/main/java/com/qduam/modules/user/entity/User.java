/**
 * 
 */
package com.qduam.modules.user.entity;

import com.qduam.common.persistence.BaseEntity;

/**
 * 用户实体
 * @author lilinzhen
 * @version 2018年1月4日
 */
public class User extends BaseEntity{

	private String logname;	//用户账号
	private String password;	//密码
	private String name;		//用户名
	private String type;		//用户类型
	private String pic;		//用户头像
	private Boolean exist_pic;//用户头像是否自定义

	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Boolean getExist_pic() {
		return exist_pic;
	}

	public void setExist_pic(Boolean exist_pic) {
		this.exist_pic = exist_pic;
	}
}
