package com.chzm.model.role;

public class UserHaveRoles {


    private Long id;
    private String userId;
    private String playRoleId;
    private String playRoleName;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlayRoleId() {
        return playRoleId;
    }

    public void setPlayRoleId(String playRoleId) {
        this.playRoleId = playRoleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlayRoleName() {
        return playRoleName;
    }

    public void setPlayRoleName(String playRoleName) {
        this.playRoleName = playRoleName;
    }
}
