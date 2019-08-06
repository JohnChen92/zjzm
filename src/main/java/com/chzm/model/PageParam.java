package com.chzm.model;

import java.io.Serializable;

/**
 * 分页参数
 *
 */
public class PageParam implements Serializable {

	private static final long serialVersionUID = -6054758045407631254L;

	/**
	 * 页码，默认第一页
	 */
	private int pageNo = 1;

	/**
	 * 每页大小，默认10条
	 */
	private int pageSize = 10;

	public PageParam() {}

	public PageParam(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "PageParam[pageNo=" + pageNo + ",pageSize=" + pageSize + "]";
	}

}
