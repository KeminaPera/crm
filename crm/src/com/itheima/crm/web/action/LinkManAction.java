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
	
	//ע��LinkManService
	LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	//����������ע��curPage��pageSize
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
	
	//ע��CustomerAction
	CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * ����������ϵ�� ,�Է�ҳ��ʽ����
	 */
	public String findAll() {
		//�������߲�ѯ����
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		//��������
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
	 * ��ת����ϵ�����ҳ��
	 */
	public String addUI() {
		List<Customer> list = customerService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "addUI";
	}
	
	/**
	 * �����ϵ��
	 */
	public String add() {
		linkManService.add(linkMan);
		return "addSuccess";
	}
	/**
	 * ɾ����ϵ��
	 */
	public String delete() {
		linkManService.delete(linkMan.getLkm_id());
		return "deleteSuccess";
	}
	/**
	 * ��ת���༭ҳ��
	 */
	public String editUI() {
		//��ȡ������ϵ��
		List<LinkMan> list = linkManService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		//����Id��ȡ����
		linkMan = linkManService.findById(linkMan.getLkm_id());
		if(linkMan != null) {
			ActionContext.getContext().getValueStack().push(linkMan);
		}
		return "editUI";
	}
	/**
	 * �޸���ϵ��
	 */
	public String edit() {
		linkManService.edit(linkMan);
		return "editSuccess";
	}
}	
