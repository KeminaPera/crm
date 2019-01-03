package com.itheima.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.UserDao;
import com.itheima.crm.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	/**
	 * �����û�
	 * user : ���û�ʵ�屣�浽���ݿ�
	 */
	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
		System.out.println("Dao�еķ�����ִ����...");
	}

	/**
	 * �����û�
	 * user : ���Ը���user�����ṩ���ֶν��в����û�
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
