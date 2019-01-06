package com.itheima.crm.service.impl;

import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.dao.CustomerDetailDao;
import com.itheima.crm.domain.Customer;
import com.itheima.crm.domain.CustomerDetail;
import com.itheima.crm.service.CustomerDetailService;
/**
 * CustomerDetailService的Service层的业务实现类
 */
public class CustomerDetailServiceImpl implements CustomerDetailService {
	
	//注入CustomerDetailDao
	CustomerDetailDao customerDetailDao;

	public void setCustomerDetailDao(CustomerDetailDao customerDetailDao) {
		this.customerDetailDao = customerDetailDao;
	}
	//注入CustomerDao
	CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}


	@Override
	//根据客户ID查询客户详细信息
	public CustomerDetail findById(Long cust_id) {
		/**
		 * 这里有问题，类之间耦合太紧密
		 */
		//调用customerDao的findById方法
		Customer customer = customerDao.findById(cust_id);
		CustomerDetail customerDetail = new CustomerDetail();
		customerDetail.setCustomer(customer);
		//调用customerDetailDao的findById方法
		customerDetailDao.findById(cust_id);
		return customerDetail;
	}
	
}
