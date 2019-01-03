package com.itheima.crm.service.impl;

import java.util.List;

import com.itheima.crm.dao.BasedictDao;
import com.itheima.crm.domain.BaseDict;
import com.itheima.crm.service.BasedictService;
/**
 * 数据字典业务层实现类
 * @author Administrator
 *
 */
public class BasedictServiceImpl implements BasedictService {

	//注入BasedictDao
	BasedictDao basedictDao;
	
	public void setBasedictDao(BasedictDao basedictDao) {
		this.basedictDao = basedictDao;
	}


	@Override
	//根据类别查询
	public List<BaseDict> findByDictTypeCode(String dict_type_code) {
		return basedictDao.findByDictTypeCode(dict_type_code);
	}

}
