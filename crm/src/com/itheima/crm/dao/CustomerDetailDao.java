package com.itheima.crm.dao;

import com.itheima.crm.domain.CustomerDetail;

public interface CustomerDetailDao {

	CustomerDetail findById(Long cust_id);

}
