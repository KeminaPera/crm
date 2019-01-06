package com.itheima.crm.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.dao.LinkManDao;
import com.itheima.crm.domain.LinkMan;
import com.itheima.crm.domain.PageModel;
import com.itheima.crm.service.LinkManService;
/**
 * 联系人Service层实现类
 * @author Administrator
 *
 */
public class LinkManServiceImpl implements LinkManService {
	//注入LinkManDao
	LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	@Override
	public PageModel<LinkMan> finAll(DetachedCriteria detachedCriteria, Integer curPage, Integer pageSize) {
		PageModel<LinkMan> pageModel = new PageModel<>();
		//设置页面大小和当前页码
		pageModel.setCurPage(curPage);
		if(pageSize == null) {
			pageSize = 3;
		}
		pageModel.setPageSize(pageSize);
		//调用LinkManDao获取总记录数
		Integer totalRecordCount = linkManDao.getTotalRecordCount(detachedCriteria);
		pageModel.setTotalRecordCount(totalRecordCount);
		//计算出总页数
		Double temp = totalRecordCount.doubleValue();
		temp = Math.ceil(temp / pageSize);
		pageModel.setTotalPageCount(temp.intValue());
		int begin = (curPage - 1)*pageSize;
		List<LinkMan> list = linkManDao.getList(detachedCriteria, begin, pageSize);
		pageModel.setList(list);
		return pageModel;
	}

	@Override
	//service层添加联系人
	@Transactional
	public void add(LinkMan linkMan) {
		linkManDao.save(linkMan);
	}

	@Override
	//service层删除联系人
	@Transactional
	public void delete(Long lkm_id) {
		LinkMan linkMan = linkManDao.findById(lkm_id);
		if(linkMan != null) {
			linkManDao.delete(linkMan);
		}
	}

	@Override
	//根据Id查找联系人
	public LinkMan findById(Long lkm_id) {
		Serializable id = lkm_id;
		return linkManDao.findById(id);
	}

	@Override
	//查找所有联系人
	public List<LinkMan> findAll() {
		return linkManDao.findAll();
	}

	@Override
	//修改联系人
	@Transactional
	public void edit(LinkMan linkMan) {
		linkManDao.update(linkMan);
	}
	
}
