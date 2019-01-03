package com.itheima.crm.web.action;

import com.itheima.crm.domain.User;
import com.itheima.crm.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	//ע��UserService����
	UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}
	//��ת��ע��ҳ��
	public String registUI() {
		return "registUI";
	}

	//����Ա�ʺ�ע��
	public String regist() {
		userService.registe(user);
		return LOGIN;
	}
	//����Ա��¼
	public String login() {
		User existUser = userService.login(user);
		if(existUser != null) {
			//���ö������session����
			ActionContext.getContext().getSession().put("existUser", existUser);
			return SUCCESS;
		}else {
			//��¼�д����ص�¼ҳ��
			this.addActionError("�û������������");
			return LOGIN;
		}
	}
}
