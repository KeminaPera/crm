package com.itheima.crm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * 抽取通用的DAO
 *
 */
public interface BaseDao<T> {
	
	void save(T t);
	
	void delete(T t);
	
	void update(T t);
	
	T findById(Serializable id);
	
	List<T> findAll();
	
	Integer getTotalRecordCount(DetachedCriteria detachedCriteria);
	
	List<T> getList(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);
}
