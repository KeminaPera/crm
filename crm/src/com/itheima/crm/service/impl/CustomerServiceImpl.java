package com.itheima.crm.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.domain.Customer;
import com.itheima.crm.service.CustomerService;

@Transactional
public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) {
		System.out.println("Service中的方法执行了..");
		customerDao.save(customer);
	}

}
