package com.itheima.crm.dao;

import com.itheima.crm.domain.User;

public interface UserDao extends BaseDao<User> {

	User findUser(User user);

}
