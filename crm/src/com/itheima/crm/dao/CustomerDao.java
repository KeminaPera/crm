package com.itheima.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.crm.domain.Customer;

public interface CustomerDao {

	void save(Customer customer);

	Integer getTotalRecordCount(DetachedCriteria detachedCriteria);

	List<Customer> getList(DetachedCriteria detachedCriteria, int i, Integer pageSize);

	void delete(Customer customer);

	Customer findCustomerById(Long cust_id);

	void update(Customer customer);

	List<Customer> findAll();
}
