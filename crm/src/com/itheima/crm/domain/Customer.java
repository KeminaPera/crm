package com.itheima.crm.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户实体类
 * @author Administrator
 *
 */
public class Customer {

	private Long cust_id;
	private String cust_name;
	private Long cust_user_id;
	private Long cust_create_id;
	//修改客户实体的对应关系
	/*private String cust_source;
	private String cust_industry;
	private String cust_level;*/
	//修改客户实体与联系人的对应关系
	/*private String cust_linkman;*/
	private String cust_phone;
	private String cust_mobile;
	private String cust_image;
	private BaseDict cust_source;
	private BaseDict cust_industry;
	private BaseDict cust_level;
	private CustomerDetail customerDetail;
	private Set<LinkMan> linkMans = new HashSet<>();
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public Long getCust_user_id() {
		return cust_user_id;
	}
	public void setCust_user_id(Long cust_user_id) {
		this.cust_user_id = cust_user_id;
	}
	public Long getCust_create_id() {
		return cust_create_id;
	}
	public void setCust_create_id(Long cust_create_id) {
		this.cust_create_id = cust_create_id;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	public BaseDict getCust_source() {
		return cust_source;
	}
	public void setCust_source(BaseDict cust_source) {
		this.cust_source = cust_source;
	}
	public BaseDict getCust_industry() {
		return cust_industry;
	}
	public void setCust_industry(BaseDict cust_industry) {
		this.cust_industry = cust_industry;
	}
	public BaseDict getCust_level() {
		return cust_level;
	}
	public void setCust_level(BaseDict cust_level) {
		this.cust_level = cust_level;
	}
	public String getCust_image() {
		return cust_image;
	}
	public void setCust_image(String cust_image) {
		this.cust_image = cust_image;
	}
	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}
	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}
	public Set<LinkMan> getLinkMans() {
		return linkMans;
	}
	public void setLinkMans(Set<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_user_id=" + cust_user_id
				+ ", cust_create_id=" + cust_create_id + ", cust_phone=" + cust_phone + ", cust_mobile=" + cust_mobile
				+ ", cust_image=" + cust_image + ", cust_source=" + cust_source + ", cust_industry=" + cust_industry
				+ ", cust_level=" + cust_level + ", customerDetail=" + customerDetail + ", linkMans的大小=" + linkMans.size() + "]";
	}
	
}
