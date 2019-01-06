package com.itheima.crm.service.impl;

import java.io.File;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.domain.Customer;
import com.itheima.crm.domain.PageModel;
import com.itheima.crm.service.CustomerService;

@Transactional
public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	//添加客户，调用Dao层的save方法
	public void add(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public PageModel<Customer> findAll(DetachedCriteria detachedCriteria, Integer curPage, Integer pageSize) {
		PageModel<Customer> pageModel = new PageModel<>();
		pageModel.setPageSize(pageSize);
		if(curPage == null) {
			curPage = 1;
		}
		pageModel.setCurPage(curPage);
		//获取总记录数
		Integer totalRecordCount = customerDao.getTotalRecordCount(detachedCriteria);
		pageModel.setTotalRecordCount(totalRecordCount);
		//计算总页面数
		double count = totalRecordCount.doubleValue();
		int totalPageSize =  (int) Math.ceil(count/pageSize);
		pageModel.setTotalPageCount(totalPageSize);
		//查询该页的所有数据
		List<Customer> list = customerDao.getList(detachedCriteria, (curPage - 1)*pageSize, pageSize);
		for (Customer customer : list) {
			System.out.println(customer.getCust_name());
		}
		pageModel.setList(list);
		return pageModel;
	}

	@Override
	//Service层客户的删除
	public void deleteById(Long cust_id) {
		//先查询客户
		Customer customer = customerDao.findCustomerById(cust_id);
		//根据查找到的信息删除图片
		if(customer != null) {
			String cust_image = customer.getCust_image();
			if(cust_image != null) {
				File file = new File(cust_image);
				if(file.exists()) {
					file.delete();
				}
			}
			//删除完图片后删除客户
			customerDao.delete(customer);
		}
	}

	@Override
	//service层修改、更新用户
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	//service层根据Id修改客户
	public Customer findCustomerById(Long cust_id) {
		return customerDao.findCustomerById(cust_id);
	}

	@Override
	//service层查询所有客户
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

}
