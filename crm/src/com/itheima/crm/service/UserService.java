package com.itheima.crm.service;

import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.domain.User;

@Transactional
public interface UserService {

	void registe(User user);

	User login(User user);

}
