package com.itheima.crm.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.CustomerDetailDao;
import com.itheima.crm.domain.CustomerDetail;
/**
 * Dao层客户详细信息实现类
 */
public class CustomerDetailDaoImpl extends HibernateDaoSupport implements CustomerDetailDao {

	@Override
	//根据客户ID查询客户详细信息
	public CustomerDetail findById(Long cust_id) {
		System.out.println("Dao方法执行了...");
		return this.getHibernateTemplate().get(CustomerDetail.class, cust_id);
	}

}
