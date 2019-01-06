package com.itheima.crm.dao.impl;

import java.util.List;

import com.itheima.crm.dao.BasedictDao;
import com.itheima.crm.domain.BaseDict;
/**
 * 数据字典DAO层实现类
 * @author Administrator
 *
 */
public class BasedictDaoImpl extends BaseDaoImpl<BaseDict> implements BasedictDao {


	public BasedictDaoImpl() {
		super(BaseDict.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BaseDict> findByDictTypeCode(String dict_type_code) {
		return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code = ? and dict_enable = ?", dict_type_code, "1");
	}

}
