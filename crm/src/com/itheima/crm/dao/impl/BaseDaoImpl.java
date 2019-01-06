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
 * 抽取出来的BaseDao接口的实现类
 *
 * @param <T>
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		//获取带有泛型的父类 相当于获取到了BaseDao<Customer>
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		//向下类型转换，转换成参数化类型
		ParameterizedType type = (ParameterizedType) genericSuperclass;
		//相当于获取到了Customer
		Type[] actualTypeArguments = type.getActualTypeArguments();
		this.clazz = (Class<T>) actualTypeArguments[0];
	}

	@Override
	//保存实体
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	//删除实体
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	//修改实体
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	//根据Id查找实体
	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	//查找满足指定条件的总记录数
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
	//获取页面的数据
	public List<T> getList(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		//先将条件设置成null
		detachedCriteria.setProjection(null);
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
	}

	@SuppressWarnings("unchecked")
	@Override
	//获取某个表的所有数据
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from "+clazz.getName());
	}
}
