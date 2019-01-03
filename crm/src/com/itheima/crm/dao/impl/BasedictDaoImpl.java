package com.itheima.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.BasedictDao;
import com.itheima.crm.domain.BaseDict;
/**
 * 数据字典DAO层实现类
 * @author Administrator
 *
 */
public class BasedictDaoImpl extends HibernateDaoSupport implements BasedictDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<BaseDict> findByDictTypeCode(String dict_type_code) {
		return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code = ? and dict_enable = ?", dict_type_code, "1");
	}

}
