package com.itheima.crm.service.impl;

import com.itheima.crm.dao.UserDao;
import com.itheima.crm.domain.User;
import com.itheima.crm.service.UserService;
import com.itheima.crm.utils.MD5Utils;
/**
 * ����Ա��ҵ���ʵ����
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService {

	//ע��UserDao����
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void registe(User user) {
		//��������м��ܲ���
		System.out.println(user);
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		//�����û���ʼ״̬Ϊ����,0Ϊ��ͣ
		user.setUser_state("1");
		userDao.save(user);
	}

	@Override
	public User login(User user) {
		//��������ܣ��������ݿ��н��бȶ�
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		return userDao.findUser(user);
	}

}
