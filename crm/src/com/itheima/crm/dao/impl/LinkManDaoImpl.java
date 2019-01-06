package com.itheima.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.LinkManDao;
import com.itheima.crm.domain.LinkMan;
/**
 * 联系人Dao层实现类
 */
public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 查询从指定页面的联系人信息
	 */
	public List<LinkMan> getList(DetachedCriteria detachedCriteria, int begin, Integer pageSize) {
		detachedCriteria.setProjection(null);
		return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 查询总记录数
	 */
	public Integer getTotalRecordCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> findByCriteria = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(findByCriteria.size() > 0) {
			return findByCriteria.get(0).intValue();
		}
		return null;
	}

	@Override
	//Dao层保存联系人
	public void save(LinkMan linkMan) {
		System.out.println(linkMan);
		this.getHibernateTemplate().save(linkMan);
	}

	@Override
	//Dao层删除联系人
	public void delete(LinkMan linkMan) {
		this.getHibernateTemplate().delete(linkMan);;
	}

	@Override
	//根据Id获取联系人对象
	public LinkMan findById(Long lkm_id) {
		return this.getHibernateTemplate().get(LinkMan.class, lkm_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	//Dao层查找所有联系人
	public List<LinkMan> findAll() {
		return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
	}

	@Override
	//Dao层修改联系人
	public Object update(LinkMan linkMan) {
		this.getHibernateTemplate().update(linkMan);
		return null;
	}

}
