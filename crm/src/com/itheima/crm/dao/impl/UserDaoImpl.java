package com.itheima.crm.dao.impl;

import java.util.List;

import com.itheima.crm.dao.UserDao;
import com.itheima.crm.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	/**
	 * 查找用户
	 * user : 可以根据user里面提供的字段进行查找用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public User findUser(User user) {
		List<User> users = (List<User>) this.getHibernateTemplate().find("from User where user_name=? and user_password=?", user.getUser_name(), user.getUser_password());
		if(users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
	
}
