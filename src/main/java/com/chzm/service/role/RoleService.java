package com.chzm.service.role;

import com.chzm.model.RequestHead;
import com.chzm.model.role.PlayRoleGroup;
import com.chzm.param.RoleSendParam;

import java.util.List;
import java.util.Map;

public interface RoleService {
    Map<String,Map<String,List<PlayRoleGroup>>> queryAllPlayRoles(String openId);

    void sendUserHaveRoles(RoleSendParam param);

    Object[] queryUserPlayRoles(RequestHead param);
}
