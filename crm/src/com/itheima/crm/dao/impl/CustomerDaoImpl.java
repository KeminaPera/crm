package com.itheima.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.domain.Customer;
/*
 * �ͻ�DAO��ʵ����
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	//����ͻ�
	public void save(Customer customer) {
		System.out.println("dao�еķ���ִ����....");
		this.getHibernateTemplate().save(customer);
	}

	@SuppressWarnings("unchecked")
	@Override
	//��ȡ�ܼ�¼��
	public Integer getTotalRecordCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> totalRecordCounts = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(totalRecordCounts.size() > 0) {
			return totalRecordCounts.get(0).intValue();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	//��ȡ��begin��ʼ��pageSize������
	public List<Customer> getList(DetachedCriteria detachedCriteria, int begin, Integer pageSize) {
		detachedCriteria.setProjection(null);
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
		return list;
	}

	@Override
	//Dao��ɾ���ͻ�
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);;
	}

	@Override
	//Dao�����ID���ҿͻ�
	public Customer findCustomerById(Long cust_id) {
		return this.getHibernateTemplate().get(Customer.class, cust_id);
	}

	@Override
	public void update(Customer customer) {
		
	}
}
