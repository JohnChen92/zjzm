package com.chzm.model.avtivity;

public class ActivityJoinDetail {

    private Long id;

    private String activityDetailId;

    private String activityName;

    private String joinUserId;

    private String joinUserName;

    private String joinPlayRoleId;

    private String joinPlayRoleName;

    private String pictureUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDetailId() {
        return activityDetailId;
    }

    public void setActivityDetailId(String activityDetailId) {
        this.activityDetailId = activityDetailId;
    }

    public String getJoinUserId() {
        return joinUserId;
    }

    public void setJoinUserId(String joinUserId) {
        this.joinUserId = joinUserId;
    }

    public String getJoinUserName() {
        return joinUserName;
    }

    public void setJoinUserName(String joinUserName) {
        this.joinUserName = joinUserName;
    }

    public String getJoinPlayRoleId() {
        return joinPlayRoleId;
    }

    public void setJoinPlayRoleId(String joinPlayRoleId) {
        this.joinPlayRoleId = joinPlayRoleId;
    }

    public String getJoinPlayRoleName() {
        return joinPlayRoleName;
    }

    public void setJoinPlayRoleName(String joinPlayRoleName) {
        this.joinPlayRoleName = joinPlayRoleName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
