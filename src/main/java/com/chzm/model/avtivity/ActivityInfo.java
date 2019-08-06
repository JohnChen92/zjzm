package com.chzm.model.avtivity;

public class ActivityInfo {
        private Long id;
        private String activityName;
        private String count;
        private String fightingNumber;
        private String remark;

        private String pictureUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getFightingNumber() {
        return fightingNumber;
    }

    public void setFightingNumber(String fightingNumber) {
        this.fightingNumber = fightingNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
