package com.itheima.crm.web.action;

import com.itheima.crm.domain.CustomerDetail;
import com.itheima.crm.service.CustomerDetailService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 *	客户详细信息的Action类 
 */
public class CustomerDetaiAction extends ActionSupport implements ModelDriven<CustomerDetail> {

	CustomerDetail customerDetail = new CustomerDetail();
	
	@Override
	public CustomerDetail getModel() {
		return customerDetail;
	}
	
	//注入CustomerDetailService类
	CustomerDetailService customerDetailService;

	public void setCustomerDetailService(CustomerDetailService customerDetailService) {
		this.customerDetailService = customerDetailService;
	}
	
	/**
	 * 跳转到客户信息编辑页面
	 */
	public String toEditUI() {
		System.out.println("--------------------"+customerDetail.getCustomer().getCust_id());
		customerDetail = customerDetailService.findById(customerDetail.getCustomer().getCust_id());
		if(customerDetail != null) {
			ActionContext.getContext().getValueStack().push(customerDetail);
		}
		System.out.println("--------------------"+customerDetail);
		return "editUI";
	}
}
