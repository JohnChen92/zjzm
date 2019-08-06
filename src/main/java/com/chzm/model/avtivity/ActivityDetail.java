package com.chzm.model.avtivity;

public class ActivityDetail {

	private long id ;

	private String activityName;

	private String createUserId;

	private String nickName;
	
	private String fightingNumber;
	
	private String startTime;
	
	private String remark;

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFightingNumber() {
		return fightingNumber;
	}

	public void setFightingNumber(String fightingNumber) {
		this.fightingNumber = fightingNumber;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
}
