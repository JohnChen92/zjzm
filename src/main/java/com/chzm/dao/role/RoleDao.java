package com.chzm.dao.role;

import com.chzm.model.role.SortRoles;
import com.chzm.model.role.UserHaveRoles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    List<SortRoles> queryRoles(@Param("openId")String openId);

    List<UserHaveRoles> queryUserHaveRoles(@Param("openId")String openId, @Param("role")String role);

    void updateUserHaveRolesById(@Param("id")Long id, @Param("status")String status);

    void insert(@Param("openId")String openId, @Param("role")String role);

    List<UserHaveRoles> queryUserPlayRoles(@Param("openId")String openId);
}
