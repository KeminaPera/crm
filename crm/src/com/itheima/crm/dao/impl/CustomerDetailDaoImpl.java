package com.itheima.crm.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.CustomerDetailDao;
import com.itheima.crm.domain.CustomerDetail;
/**
 * Dao��ͻ���ϸ��Ϣʵ����
 */
public class CustomerDetailDaoImpl extends HibernateDaoSupport implements CustomerDetailDao {

	@Override
	//���ݿͻ�ID��ѯ�ͻ���ϸ��Ϣ
	public CustomerDetail findById(Long cust_id) {
		System.out.println("Dao����ִ����...");
		return this.getHibernateTemplate().get(CustomerDetail.class, cust_id);
	}

}
