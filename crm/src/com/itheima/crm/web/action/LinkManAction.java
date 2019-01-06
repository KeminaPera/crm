package com.itheima.crm.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.itheima.crm.domain.Customer;
import com.itheima.crm.domain.LinkMan;
import com.itheima.crm.domain.PageModel;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	LinkMan linkMan = new LinkMan();
	@Override
	public LinkMan getModel() {
		return linkMan;
	}
	
	//注入LinkManService
	LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	//以属性驱动注入curPage和pageSize
	private Integer curPage = 1;
	
	public void setCurPage(Integer curPage) {
		if(curPage == null) {
			curPage = 1;
		}
		this.curPage = curPage;
	}
	
	private Integer pageSize;

	public void setPageSize(Integer pageSize) {
		if(pageSize == null) {
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}
	
	//注入CustomerAction
	CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * 查找所有联系人 ,以分页形式返回
	 */
	public String findAll() {
		//创建离线查询条件
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		//设置条件
		if(linkMan.getLkm_name() != null && !"".equals(linkMan.getLkm_name())) {
			detachedCriteria.add(Restrictions.like("lkm_name", linkMan.getLkm_name()+"%"));
		}
		if(linkMan.getLkm_gender() != null && !"".equals(linkMan.getLkm_gender().toString())) {
			detachedCriteria.add(Restrictions.eq("lkm_gender", linkMan.getLkm_gender()));
		}
		PageModel<LinkMan> pageModel = linkManService.finAll(detachedCriteria, curPage, pageSize);
		ActionContext.getContext().getValueStack().push(pageModel);
		return "findAll";
	}
	
	/**
	 * 跳转到联系人添加页面
	 */
	public String addUI() {
		List<Customer> list = customerService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "addUI";
	}
	
	/**
	 * 添加联系人
	 */
	public String add() {
		linkManService.add(linkMan);
		return "addSuccess";
	}
	/**
	 * 删除联系人
	 */
	public String delete() {
		linkManService.delete(linkMan.getLkm_id());
		return "deleteSuccess";
	}
	/**
	 * 跳转到编辑页面
	 */
	public String editUI() {
		//获取所有联系人
		List<LinkMan> list = linkManService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		//根据Id获取对象
		linkMan = linkManService.findById(linkMan.getLkm_id());
		if(linkMan != null) {
			ActionContext.getContext().getValueStack().push(linkMan);
		}
		return "editUI";
	}
	/**
	 * 修改联系人
	 */
	public String edit() {
		linkManService.edit(linkMan);
		return "editSuccess";
	}
}	
