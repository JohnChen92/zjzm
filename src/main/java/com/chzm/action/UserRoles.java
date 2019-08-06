package com.chzm.action;


import com.alibaba.fastjson.JSON;
import com.chzm.model.RequestHead;
import com.chzm.model.role.PlayRoleGroup;
import com.chzm.model.sys.RespenseBean;
import com.chzm.param.AuthQueryParam;
import com.chzm.param.RoleSendParam;
import com.chzm.service.role.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/role")
public class UserRoles {


    private static final Logger logger = LoggerFactory.getLogger(UserRoles.class);

    @Autowired
    private RoleService RoleService;

    /**
     *     拥有角色数据回显
     */
    @RequestMapping("userHaveRoles")
    @ResponseBody
    public RespenseBean<?> userHaveRoles(HttpServletRequest request, RequestHead param){
        logger.info("userHaveRoles:{}", JSON.toJSONString(param));
        Map<String,Map<String,List<PlayRoleGroup>>> allPlayRoles = null;
        try {
            //查询玩家设定的Roles
                //组合所有的role数据
                allPlayRoles = RoleService.queryAllPlayRoles(param.getOpenId());

        } catch (Exception e) {
            logger.info("userHaveRoles error!",e);
            return new RespenseBean("FAIL", "error", "查询失败！");
        }
        return  new RespenseBean("SUCCESS", "success", "查询成功！",JSON.toJSONString(allPlayRoles),null);
    }

    /**
     *  角色设置提交
     *  提交的角色判断是否已经已存在或状态为删除
     *  处理
     */
    @RequestMapping("sendUserHaveRoles")
    @ResponseBody
    public RespenseBean<?> sendUserHaveRoles(HttpServletRequest request, RoleSendParam param){
        logger.info("sendUserHaveRoles:{}", JSON.toJSONString(param));
        try {
            RoleService.sendUserHaveRoles(param);

        } catch (Exception e) {
            logger.info("sendUserHaveRoles error!",e);
            return new RespenseBean("FAIL", "error", "查询失败！");
        }
        return  new RespenseBean("SUCCESS", "success", "查询成功！");
    }

    /**
     * 已有角色
     */
    @RequestMapping("userOwnRole")
    @ResponseBody
    public RespenseBean<?> userOwnRole(HttpServletRequest request, RequestHead param){
        logger.info("userOwnRole:{}", JSON.toJSONString(param));
        Object[] str = null;
        try {
            str = RoleService.queryUserPlayRoles(param);

        } catch (Exception e) {
            logger.info("userOwnRole error!",e);
            return new RespenseBean("FAIL", "error", "查询失败！");
        }
        logger.info("userOwnRole:{}", JSON.toJSONString(str));

        return  new RespenseBean("SUCCESS", "success", "查询成功！", JSON.toJSONString(str),null);
    }

}
