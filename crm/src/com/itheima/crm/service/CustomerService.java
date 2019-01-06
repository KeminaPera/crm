package com.itheima.crm.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.crm.domain.Customer;
import com.itheima.crm.domain.PageModel;

public interface CustomerService {
	void add(Customer customer);

	PageModel<Customer> findAll(DetachedCriteria detachedCriteria, Integer curPage, Integer pageSize);

	void deleteById(Long cust_id);

	void update(Customer customer);

	Customer findCustomerById(Long cust_id);

	List<Customer> findAll();
}
