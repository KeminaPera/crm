package com.itheima.crm.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.itheima.crm.domain.Customer;
import com.itheima.crm.domain.PageModel;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.FileUploadUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	//注入customerService对象
	CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	Customer customer = new Customer();

	@Override
	public Customer getModel() {
		return customer;
	}
	
	//以属性驱动获取当前页码
	private Integer curPage = 1;
	
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	private Integer pageSize = 3;

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	//文件上传的属性注册
	private String uploadFileName;
	private File upload;
	private String uploadContentType;

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	//添加客户
	public String add() throws IOException {
		if(upload != null) {
			//获取存储路径
			String newFileName = FileUploadUtil.getFileName(uploadFileName);
			String savePath = FileUploadUtil.getSavePath(newFileName);
			String path = "d:/crm_images";
			String realPath = path + savePath ;
			File file = new File(realPath);
			if(!file.exists()) {
				file.mkdirs();
			}
			File realFile = new File(realPath, newFileName);
			FileUtils.copyFile(upload, realFile);
			customer.setCust_image(realPath+"/"+newFileName);
		}
		customerService.add(customer);
		return "addSuccess";
	}
	
	//查询所有客户信息，以分页形式回显
	public String findAll() {
		System.out.println("---------------------------"+curPage);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		System.out.println("----"+customer.getCust_name()+"----");
		System.out.println("".equals(customer.getCust_name()));
		System.out.println(customer.getCust_name() != null);
		if(customer.getCust_level() != null) {
		System.out.println("----"+customer.getCust_level().getDict_id()+"----");
		}
		if(customer.getCust_source() != null) {
		System.out.println("----"+customer.getCust_source().getDict_id()+"----");
		}
		if(customer.getCust_name() != null && !"".equals(customer.getCust_name())) {
			detachedCriteria.add(Restrictions.like("cust_name", customer.getCust_name()+"%"));
		}
		if(customer.getCust_level() != null && customer.getCust_level().getDict_id() != null) {
			detachedCriteria.add(Restrictions.eq("cust_level.dict_id", customer.getCust_level().getDict_id()));
		}
		if(customer.getCust_source() != null && customer.getCust_source().getDict_id() != null) {
			detachedCriteria.add(Restrictions.eq("cust_source.dict_id", customer.getCust_source().getDict_id()));
		}
		PageModel<Customer> pageModel = customerService.findAll(detachedCriteria, curPage, pageSize);
		//将其存入值栈，并跳转页面
		ActionContext.getContext().getValueStack().push(pageModel);
		return "list";
	}
	
	/*
	 * 根据顾客ID删除顾客
	 */
	public String deleteById() {
		customerService.deleteById(customer.getCust_id());
		return "deleteSuccess";
	}
	/**
	 * 跳转到顾客修改页面
	 */
	public String toUpdateUI() {
		customer = customerService.findCustomerById(customer.getCust_id());
		//将查找到的对象放到值栈中
		ActionContext.getContext().getValueStack().push(customer);
		return "updateUI";
	}
	/**
	 * 修改/更新客户
	 */
	public String update() {
		System.out.println(customer.getCust_level().getDict_id()+"-------");
		System.out.println(customer.getCust_source().getDict_id()+"=======");
		customerService.update(customer);
		return "updateSuccess";
	}
}
