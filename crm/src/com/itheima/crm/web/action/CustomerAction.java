package com.itheima.crm.web.action;

import com.itheima.crm.domain.Customer;
import com.itheima.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	CustomerService customerService;
	
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	Customer customer = new Customer();

	@Override
	public Customer getModel() {
		return customer;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("÷¥––¡À...");
		customerService.save(customer);
		return NONE;
	}

	
}
