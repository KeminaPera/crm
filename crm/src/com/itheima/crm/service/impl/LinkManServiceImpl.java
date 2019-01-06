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
 * ��ϵ��Service��ʵ����
 * @author Administrator
 *
 */
public class LinkManServiceImpl implements LinkManService {
	//ע��LinkManDao
	LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	@Override
	public PageModel<LinkMan> finAll(DetachedCriteria detachedCriteria, Integer curPage, Integer pageSize) {
		PageModel<LinkMan> pageModel = new PageModel<>();
		//����ҳ���С�͵�ǰҳ��
		pageModel.setCurPage(curPage);
		if(pageSize == null) {
			pageSize = 3;
		}
		pageModel.setPageSize(pageSize);
		//����LinkManDao��ȡ�ܼ�¼��
		Integer totalRecordCount = linkManDao.getTotalRecordCount(detachedCriteria);
		pageModel.setTotalRecordCount(totalRecordCount);
		//�������ҳ��
		Double temp = totalRecordCount.doubleValue();
		temp = Math.ceil(temp / pageSize);
		pageModel.setTotalPageCount(temp.intValue());
		int begin = (curPage - 1)*pageSize;
		List<LinkMan> list = linkManDao.getList(detachedCriteria, begin, pageSize);
		pageModel.setList(list);
		return pageModel;
	}

	@Override
	//service�������ϵ��
	@Transactional
	public void add(LinkMan linkMan) {
		linkManDao.save(linkMan);
	}

	@Override
	//service��ɾ����ϵ��
	@Transactional
	public void delete(Long lkm_id) {
		LinkMan linkMan = linkManDao.findById(lkm_id);
		if(linkMan != null) {
			linkManDao.delete(linkMan);
		}
	}

	@Override
	//����Id������ϵ��
	public LinkMan findById(Long lkm_id) {
		Serializable id = lkm_id;
		return linkManDao.findById(id);
	}

	@Override
	//����������ϵ��
	public List<LinkMan> findAll() {
		return linkManDao.findAll();
	}

	@Override
	//�޸���ϵ��
	@Transactional
	public void edit(LinkMan linkMan) {
		linkManDao.update(linkMan);
	}
	
}
