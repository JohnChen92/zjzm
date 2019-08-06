package com.chzm.service.role.impl;

import com.alibaba.fastjson.JSON;
import com.chzm.dao.role.RoleDao;
import com.chzm.model.RequestHead;
import com.chzm.model.role.GroupRoles;
import com.chzm.model.role.PlayRoleGroup;
import com.chzm.model.role.SortRoles;
import com.chzm.model.role.UserHaveRoles;
import com.chzm.param.RoleSendParam;
import com.chzm.service.role.RoleService;
import com.chzm.utils.EmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public Map<String,Map<String,List<PlayRoleGroup>>> queryAllPlayRoles(String openId) {
        //查破招
        List<SortRoles> roles = roleDao.queryRoles(openId);

        //组合
        Map<String,Map<String,List<PlayRoleGroup>>> map = new HashMap<>();
        for (SortRoles sortRoles:roles) {
            Map<String,List<PlayRoleGroup>>  gmap = new HashMap<>();
            for (GroupRoles groupRoles:sortRoles.getGroupRoles()) {
                gmap.put(groupRoles.getGroup(),groupRoles.getRoles());
            }
            map.put(sortRoles.getSort(),gmap);
        }

        return map;
    }

    @Override
    public void sendUserHaveRoles(RoleSendParam param) {
        String[] roles = JSON.parseObject(param.getSelectRoles(),String[].class);
        String[] removerRoles = JSON.parseObject(param.getRemoveRoles(),String[].class);
        //删除
        for (String rRole: removerRoles) {
            List<UserHaveRoles> have = roleDao.queryUserHaveRoles(param.getOpenId(),rRole);
            if(EmptyUtil.notEmpty(have)){
                roleDao.updateUserHaveRolesById(have.get(0).getId(),"FAIL");
            }
        }

        for (String role: roles) {
            //检查have表
            List<UserHaveRoles> have = roleDao.queryUserHaveRoles(param.getOpenId(),role);
            //存在状态不生效修改状态
            if(EmptyUtil.notEmpty(have)){
                UserHaveRoles userHaveRoles =  have.get(0);
                if(!"EFFECT".equals(userHaveRoles.getStatus())){
                    roleDao.updateUserHaveRolesById(userHaveRoles.getId(),"EFFECT");
                }
            }else{
                //不存在插入
                roleDao.insert(param.getOpenId(),role);
            }

        }
    }

    @Override
    public Object[] queryUserPlayRoles(RequestHead param) {
        List<UserHaveRoles> list = roleDao.queryUserPlayRoles(param.getOpenId());

        List<String> stringList = new ArrayList<>();
        for (UserHaveRoles r : list) {
            stringList.add(r.getPlayRoleName());
        }
        return stringList.toArray();
    }
}
