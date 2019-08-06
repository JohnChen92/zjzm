package com.chzm.model.sys;

import java.util.List;

import com.github.pagehelper.PageInfo;

/*
 * 公共返回Bean
 */
public class RespenseBean<T> {
	
	  public RespenseBean() {}
		
	  public RespenseBean(String status,String responseCode,String showMsg) {
		  this.status = status;
		  this.responseCode = responseCode;
		  this.showMsg = showMsg;
	  }
	  
	  public RespenseBean(String status,String responseCode,String showMsg, List<T> responseDetail,PageInfo<T> pageInfo) {
		  this.status = status;
		  this.responseCode = responseCode;
		  this.showMsg = showMsg;
		  this.responseDetail = responseDetail;
	  }

	public RespenseBean(String status,String responseCode,String showMsg, String responseJson,PageInfo<T> pageInfo) {
		this.status = status;
		this.responseCode = responseCode;
		this.showMsg = showMsg;
		this.responseJson = responseJson;
	}
	  
	  private PageInfo<T> pageInfo;
	  
	  private String status;
	  
	  private String responseCode;
	  
	  private List<T> responseDetail;

	  private String responseJson;
	  
	  private String showMsg;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public List<T> getResponseDetail() {
		return responseDetail;
	}

	public void setResponseDetail(List<T> responseDetail) {
		this.responseDetail = responseDetail;
	}

	public String getShowMsg() {
		return showMsg;
	}

	public void setShowMsg(String showMsg) {
		this.showMsg = showMsg;
	}

	public PageInfo<T> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<T> pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(String responseJson) {
		this.responseJson = responseJson;
	}
}
