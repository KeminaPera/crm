package com.itheima.crm.domain;

/**
 * 客户详细信息实体类
 */
public class CustomerDetail {

	private Long cust_id;
	private String cust_region;
	private String cust_zip;
	private String cust_address;
	private String cust_fax;
	private String cust_website;
	private String cust_licence;
	private String cust_corporation;
	private Long cust_capital;
	private String cust_bank;
	private String cust_memo;
	private Customer customer = new Customer();
	
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_region() {
		return cust_region;
	}
	public void setCust_region(String cust_region) {
		this.cust_region = cust_region;
	}
	public String getCust_zip() {
		return cust_zip;
	}
	public void setCust_zip(String cust_zip) {
		this.cust_zip = cust_zip;
	}
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public String getCust_fax() {
		return cust_fax;
	}
	public void setCust_fax(String cust_fax) {
		this.cust_fax = cust_fax;
	}
	public String getCust_website() {
		return cust_website;
	}
	public void setCust_website(String cust_website) {
		this.cust_website = cust_website;
	}
	public String getCust_licence() {
		return cust_licence;
	}
	public void setCust_licence(String cust_licence) {
		this.cust_licence = cust_licence;
	}
	public String getCust_corporation() {
		return cust_corporation;
	}
	public void setCust_corporation(String cust_corporation) {
		this.cust_corporation = cust_corporation;
	}
	public Long getCust_capital() {
		return cust_capital;
	}
	public void setCust_capital(Long cust_capital) {
		this.cust_capital = cust_capital;
	}
	public String getCust_bank() {
		return cust_bank;
	}
	public void setCust_bank(String cust_bank) {
		this.cust_bank = cust_bank;
	}
	public String getCust_memo() {
		return cust_memo;
	}
	public void setCust_memo(String cust_memo) {
		this.cust_memo = cust_memo;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerDetail [cust_id=" + cust_id + ", cust_region=" + cust_region + ", cust_zip=" + cust_zip
				+ ", cust_address=" + cust_address + ", cust_fax=" + cust_fax + ", cust_website=" + cust_website
				+ ", cust_licence=" + cust_licence + ", cust_corporation=" + cust_corporation + ", cust_capital="
				+ cust_capital + ", cust_bank=" + cust_bank + ", cust_memo=" + cust_memo + "]";
	}
	
}
