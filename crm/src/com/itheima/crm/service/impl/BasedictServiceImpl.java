package com.itheima.crm.service.impl;

import java.util.List;

import com.itheima.crm.dao.BasedictDao;
import com.itheima.crm.domain.BaseDict;
import com.itheima.crm.service.BasedictService;
/**
 * �����ֵ�ҵ���ʵ����
 * @author Administrator
 *
 */
public class BasedictServiceImpl implements BasedictService {

	//ע��BasedictDao
	BasedictDao basedictDao;
	
	public void setBasedictDao(BasedictDao basedictDao) {
		this.basedictDao = basedictDao;
	}


	@Override
	//��������ѯ
	public List<BaseDict> findByDictTypeCode(String dict_type_code) {
		return basedictDao.findByDictTypeCode(dict_type_code);
	}

}
