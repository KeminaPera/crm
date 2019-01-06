package com.itheima.crm.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.BaseDao;
import com.itheima.crm.domain.Customer;
/**
 * ��ȡ������BaseDao�ӿڵ�ʵ����
 *
 * @param <T>
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		//��ȡ���з��͵ĸ��� �൱�ڻ�ȡ����BaseDao<Customer>
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		//��������ת����ת���ɲ���������
		ParameterizedType type = (ParameterizedType) genericSuperclass;
		//�൱�ڻ�ȡ����Customer
		Type[] actualTypeArguments = type.getActualTypeArguments();
		this.clazz = (Class<T>) actualTypeArguments[0];
	}

	@Override
	//����ʵ��
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	//ɾ��ʵ��
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	//�޸�ʵ��
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	//����Id����ʵ��
	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	//��������ָ���������ܼ�¼��
	public Integer getTotalRecordCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size() > 0) {
			return list.get(0).intValue();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	//��ȡҳ�������
	public List<T> getList(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		//�Ƚ��������ó�null
		detachedCriteria.setProjection(null);
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
	}

	@SuppressWarnings("unchecked")
	@Override
	//��ȡĳ�������������
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from "+clazz.getName());
	}
}
