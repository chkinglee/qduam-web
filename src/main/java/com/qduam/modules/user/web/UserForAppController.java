/**
 * 
 */
package com.qduam.modules.user.web;

import javax.servlet.http.HttpServletResponse;

import com.qduam.common.persistence.BaseForAppController;
import com.qduam.modules.user.entity.User;
import com.qduam.modules.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qduam.modules.user.service.UserForAppService;
import com.qduam.common.json.AjaxJson;

import net.sf.json.JSONObject;

/**
 * TODO
 * @author lilinzhen
 * @version 2017年12月13日
 */

@Controller
@RequestMapping(value = "/app/user")
public class UserForAppController extends BaseForAppController {

	
	@Autowired
	private UserForAppService userForAppService;
	@Autowired
	private UserService userService;

	/**
	 * 登录
	 * 
	 * @param logname 用户名
	 * @param password 密码
	 * @return json 结果
	 */
	@RequestMapping(value = "/login")//, method = RequestMethod.POST
	public String login(@RequestParam("logname") String logname, @RequestParam("password") String password, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		try {
			if (StringUtils.isEmpty(logname) || StringUtils.isEmpty(password)) {
				setAjaxJsonError1(j);
			} else {
				userForAppService.getUserByLogname(logname,password,j);
			}
		} catch (Exception e) {
			e.printStackTrace();
			setAjaxJsonError0(j);
		}
        return renderString(response, j.getJsonStr());
	}

	/**
	 * 获取用户数据
	 * @param logname
	 * @param type
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/user")
	public String student(@RequestParam("logname") String logname, @RequestParam("type") String type, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		try {
			if(type.equals("1")) {
				userForAppService.getStudent(logname,j);
			}
			if(type.equals("2")) {
				userForAppService.getDepart(logname,j);
			}
		} catch (Exception e) {
			e.printStackTrace();
			setAjaxJsonError0(j);
		}
        return renderString(response, j.getJsonStr());
	}

	@RequestMapping(value = "/user/save")
	public synchronized String saveUser(@RequestParam("obj") String obj,HttpServletResponse response) throws Exception{

		AjaxJson j = new AjaxJson();
		try{
			JSONObject jsonOb = JSONObject.fromObject(obj);
			User user = (User) JSONObject.toBean(jsonOb, User.class);
			if(userService.update(user)>0){
				j.put("result", "success");
			} else {
				j.put("result", "fail");
			}
		}catch(Exception e){
			setAjaxJsonError0(j);
		}
		return renderString(response, j.getJsonStr());
	}





}
