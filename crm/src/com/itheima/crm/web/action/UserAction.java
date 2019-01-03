package com.itheima.crm.web.action;

import com.itheima.crm.domain.User;
import com.itheima.crm.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	//注入UserService对象
	UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}
	//跳转到注册页面
	public String registUI() {
		return "registUI";
	}

	//管理员帐号注册
	public String regist() {
		userService.registe(user);
		return LOGIN;
	}
	//管理员登录
	public String login() {
		User existUser = userService.login(user);
		if(existUser != null) {
			//将该对象放入session里面
			ActionContext.getContext().getSession().put("existUser", existUser);
			return SUCCESS;
		}else {
			//登录有错，返回登录页面
			this.addActionError("用户名或密码错误！");
			return LOGIN;
		}
	}
}
