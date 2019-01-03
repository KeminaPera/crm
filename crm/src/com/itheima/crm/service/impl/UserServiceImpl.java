package com.itheima.crm.service.impl;

import com.itheima.crm.dao.UserDao;
import com.itheima.crm.domain.User;
import com.itheima.crm.service.UserService;
import com.itheima.crm.utils.MD5Utils;
/**
 * 管理员的业务层实现类
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService {

	//注入UserDao对象
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void registe(User user) {
		//对密码进行加密操作
		System.out.println(user);
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		//设置用户初始状态为正常,0为暂停
		user.setUser_state("1");
		userDao.save(user);
	}

	@Override
	public User login(User user) {
		//将密码加密，并到数据库中进行比对
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		return userDao.findUser(user);
	}

}
