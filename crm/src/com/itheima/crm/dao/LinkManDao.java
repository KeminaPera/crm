package com.itheima.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.crm.domain.LinkMan;

public interface LinkManDao {

	List<LinkMan> getList(DetachedCriteria detachedCriteria, int begin, Integer pageSize);

	Integer getTotalRecordCount(DetachedCriteria detachedCriteria);

	void save(LinkMan linkMan);

	void delete(LinkMan linkMan);

	LinkMan findById(Long lkm_id);

	List<LinkMan> findAll();

	Object update(LinkMan linkMan);

}
