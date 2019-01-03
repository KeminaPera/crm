package com.itheima.crm.domain;

import java.util.List;

public class PageModel<T> {

	private Integer curPage;			//当前页
	private Integer totalRecordCount;	//总记录数
	private Integer totalPageCount;		//总页面数
	private Integer pageSize;			//页面数据条数
	private List<T> list;				//该页面的数据
	
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getTotalRecordCount() {
		return totalRecordCount;
	}
	public void setTotalRecordCount(Integer totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}
	public Integer getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
