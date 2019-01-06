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
	//��ӿͻ�������Dao���save����
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
		//��ȡ�ܼ�¼��
		Integer totalRecordCount = customerDao.getTotalRecordCount(detachedCriteria);
		pageModel.setTotalRecordCount(totalRecordCount);
		//������ҳ����
		double count = totalRecordCount.doubleValue();
		int totalPageSize =  (int) Math.ceil(count/pageSize);
		pageModel.setTotalPageCount(totalPageSize);
		//��ѯ��ҳ����������
		List<Customer> list = customerDao.getList(detachedCriteria, (curPage - 1)*pageSize, pageSize);
		for (Customer customer : list) {
			System.out.println(customer.getCust_name());
		}
		pageModel.setList(list);
		return pageModel;
	}

	@Override
	//Service��ͻ���ɾ��
	public void deleteById(Long cust_id) {
		//�Ȳ�ѯ�ͻ�
		Customer customer = customerDao.findCustomerById(cust_id);
		//���ݲ��ҵ�����Ϣɾ��ͼƬ
		if(customer != null) {
			String cust_image = customer.getCust_image();
			if(cust_image != null) {
				File file = new File(cust_image);
				if(file.exists()) {
					file.delete();
				}
			}
			//ɾ����ͼƬ��ɾ���ͻ�
			customerDao.delete(customer);
		}
	}

	@Override
	//service���޸ġ������û�
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	//service�����Id�޸Ŀͻ�
	public Customer findCustomerById(Long cust_id) {
		return customerDao.findCustomerById(cust_id);
	}

	@Override
	//service���ѯ���пͻ�
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

}
