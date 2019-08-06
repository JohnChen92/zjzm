package com.chzm.param;

import com.chzm.model.RequestHead;

public class RoleSendParam extends RequestHead {

    private String selectRoles;

    private String removeRoles;

    public String getSelectRoles() {
        return selectRoles;
    }

    public void setSelectRoles(String selectRoles) {
        this.selectRoles = selectRoles;
    }

    public String getRemoveRoles() {
        return removeRoles;
    }

    public void setRemoveRoles(String removeRoles) {
        this.removeRoles = removeRoles;
    }
}
