package com.chzm.param;

import com.chzm.model.RequestHead;

public class ActivityQueryParam extends RequestHead{

	private String activityName;

	private String activityId;

	private String playRoleId;

	private String startTime;
	
	private String endTime;

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPlayRoleId() {
		return playRoleId;
	}

	public void setPlayRoleId(String playRoleId) {
		this.playRoleId = playRoleId;
	}
}
