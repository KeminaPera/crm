package com.itheima.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.LinkManDao;
import com.itheima.crm.domain.LinkMan;
/**
 * ��ϵ��Dao��ʵ����
 */
public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * ��ѯ��ָ��ҳ�����ϵ����Ϣ
	 */
	public List<LinkMan> getList(DetachedCriteria detachedCriteria, int begin, Integer pageSize) {
		detachedCriteria.setProjection(null);
		return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * ��ѯ�ܼ�¼��
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
	//Dao�㱣����ϵ��
	public void save(LinkMan linkMan) {
		System.out.println(linkMan);
		this.getHibernateTemplate().save(linkMan);
	}

	@Override
	//Dao��ɾ����ϵ��
	public void delete(LinkMan linkMan) {
		this.getHibernateTemplate().delete(linkMan);;
	}

	@Override
	//����Id��ȡ��ϵ�˶���
	public LinkMan findById(Long lkm_id) {
		return this.getHibernateTemplate().get(LinkMan.class, lkm_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	//Dao�����������ϵ��
	public List<LinkMan> findAll() {
		return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
	}

	@Override
	//Dao���޸���ϵ��
	public Object update(LinkMan linkMan) {
		this.getHibernateTemplate().update(linkMan);
		return null;
	}

}
