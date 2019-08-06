package com.chzm.model.role;

import java.util.List;

public class GroupRoles {

    private String group;

    List<PlayRoleGroup> roles;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<PlayRoleGroup> getRoles() {
        return roles;
    }

    public void setRoles(List<PlayRoleGroup> roles) {
        this.roles = roles;
    }
}
