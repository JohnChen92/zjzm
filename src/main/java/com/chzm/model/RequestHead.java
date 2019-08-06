package com.chzm.model;

public class RequestHead {

	private String id;
	
	private String openId;
	
	private String pageNum;
	
	private String pageSiz;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getPageSiz() {
		return pageSiz;
	}

	public void setPageSiz(String pageSiz) {
		this.pageSiz = pageSiz;
	}

}
