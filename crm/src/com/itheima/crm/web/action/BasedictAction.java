package com.itheima.crm.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.itheima.crm.domain.BaseDict;
import com.itheima.crm.service.BasedictService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
/**
 * �����ֵ�action��
 * @author Administrator
 */
public class BasedictAction extends ActionSupport implements ModelDriven<BaseDict> {

	BaseDict basedict = new BaseDict();
	@Override
	public BaseDict getModel() {
		return basedict;
	}
	
	//ע��BasedictService
	BasedictService basedictService;
	
	public void setBasedictService(BasedictService basedictService) {
		this.basedictService = basedictService;
	}


	//��������ѯ
	public String findByDictTypeCode() throws IOException{
		List<BaseDict> list = basedictService.findByDictTypeCode(basedict.getDict_type_code());
		//��list����ת����json���ݲ�����
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] {"dict_enable","dict_memo","dict_sort","dict_item_code"});
		JSONArray array = JSONArray.fromObject(list, jsonConfig);
		//System.out.println(array.toString());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("html/text;charset=utf-8");
		response.getWriter().println(array);
		
		return 	NONE;	
		
	}

}
