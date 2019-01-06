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

	//ע��customerService����
	CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	Customer customer = new Customer();

	@Override
	public Customer getModel() {
		return customer;
	}
	
	//������������ȡ��ǰҳ��
	private Integer curPage = 1;
	
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	private Integer pageSize = 3;

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	//�ļ��ϴ�������ע��
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

	//��ӿͻ�
	public String add() throws IOException {
		if(upload != null) {
			//��ȡ�洢·��
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
	
	//��ѯ���пͻ���Ϣ���Է�ҳ��ʽ����
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
		//�������ֵջ������תҳ��
		ActionContext.getContext().getValueStack().push(pageModel);
		return "list";
	}
	
	/*
	 * ���ݹ˿�IDɾ���˿�
	 */
	public String deleteById() {
		customerService.deleteById(customer.getCust_id());
		return "deleteSuccess";
	}
	/**
	 * ��ת���˿��޸�ҳ��
	 */
	public String toUpdateUI() {
		customer = customerService.findCustomerById(customer.getCust_id());
		//�����ҵ��Ķ���ŵ�ֵջ��
		ActionContext.getContext().getValueStack().push(customer);
		return "updateUI";
	}
	/**
	 * �޸�/���¿ͻ�
	 */
	public String update() {
		System.out.println(customer.getCust_level().getDict_id()+"-------");
		System.out.println(customer.getCust_source().getDict_id()+"=======");
		customerService.update(customer);
		return "updateSuccess";
	}
}
