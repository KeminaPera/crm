package com.itheima.crm.dao;

import java.util.List;

import com.itheima.crm.domain.BaseDict;

public interface BasedictDao extends BaseDao<BaseDict> {

	List<BaseDict> findByDictTypeCode(String dict_type_code);

}
