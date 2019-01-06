package com.itheima.crm.service.impl;

import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.dao.CustomerDetailDao;
import com.itheima.crm.domain.Customer;
import com.itheima.crm.domain.CustomerDetail;
import com.itheima.crm.service.CustomerDetailService;
/**
 * CustomerDetailService��Service���ҵ��ʵ����
 */
public class CustomerDetailServiceImpl implements CustomerDetailService {
	
	//ע��CustomerDetailDao
	CustomerDetailDao customerDetailDao;

	public void setCustomerDetailDao(CustomerDetailDao customerDetailDao) {
		this.customerDetailDao = customerDetailDao;
	}
	//ע��CustomerDao
	CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}


	@Override
	//���ݿͻ�ID��ѯ�ͻ���ϸ��Ϣ
	public CustomerDetail findById(Long cust_id) {
		/**
		 * ���������⣬��֮�����̫����
		 */
		//����customerDao��findById����
		Customer customer = customerDao.findById(cust_id);
		CustomerDetail customerDetail = new CustomerDetail();
		customerDetail.setCustomer(customer);
		//����customerDetailDao��findById����
		customerDetailDao.findById(cust_id);
		return customerDetail;
	}
	
}
