package com.itheima.crm.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.crm.domain.LinkMan;
import com.itheima.crm.domain.PageModel;

public interface LinkManService {

	PageModel<LinkMan> finAll(DetachedCriteria detachedCriteria, Integer curPage, Integer pageSize);

	void add(LinkMan linkMan);

	void delete(Long lkm_id);

	LinkMan findById(Long lkm_id);

	List<LinkMan> findAll();

	void edit(LinkMan linkMan);

}
