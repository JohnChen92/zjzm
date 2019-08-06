package com.chzm.action;

import com.alibaba.fastjson.JSON;
import com.chzm.model.sys.RespenseBean;
import com.chzm.model.user.User;
import com.chzm.param.AuthQueryParam;
import com.chzm.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/auth")
public class Auth {

    private static final Logger logger = LoggerFactory.getLogger(Auth.class);


    @Autowired
    private UserService userService;


    //设置服务器
    @RequestMapping("setServer")
    @ResponseBody
    public RespenseBean<?> setServer(HttpServletRequest request, User param){
        logger.info("setServer:{}",JSON.toJSONString(param));
        try {
            userService.UpdateUser(param);
        } catch (Exception e) {
            logger.info("setServer error!",e);
            return new RespenseBean("FAIL", "setServerFail", "设置失败！");
        }
        return  new RespenseBean("SUCCESS", "setServerSuccess", "设置成功！");
    }


    /**
     * 查询是否管理员权限
     */
    @RequestMapping("checkAdmin")
    @ResponseBody
    public RespenseBean<?> checkAdmin(HttpServletRequest request, AuthQueryParam param){
        logger.info("checkAdmin:{}", JSON.toJSONString(param));
        boolean flag = false;
        try {
            //查询列表
            flag = userService.checkAdmin(param.getOpenId());
        } catch (Exception e) {
            logger.info("checkAdmin error!",e);
            return new RespenseBean("FAIL", "error", "查询失败！");
        }
        return  new RespenseBean("SUCCESS", String.valueOf(flag), "查询成功！");
    }

    /**
     * 查询是否自己的权限
     */
    @RequestMapping("checkSelfAuthByJoinDetail")
    @ResponseBody
    public RespenseBean<?> checkSelfAuthByJoinDetail(HttpServletRequest request, AuthQueryParam param){
        logger.info("checkSelfAuthByJoinDetail:{}", JSON.toJSONString(param));
        boolean flag = false;
        try {
            //查询列表
            flag = userService.checkSelfAuthByJoinDetail(param.getOpenId(),param.getId());
        } catch (Exception e) {
            logger.info("checkSelfAuthByJoinDetail error!",e);
            return new RespenseBean("FAIL", "error", "查询失败！");
        }
        return  new RespenseBean("SUCCESS", String.valueOf(flag), "查询成功！");
    }

    /**
     * 查询是否自己的权限
     */
    @RequestMapping("checkSelfAuthByActivityDetail")
    @ResponseBody
    public RespenseBean<?> checkSelfAuthByActivityDetail(HttpServletRequest request, AuthQueryParam param){
        logger.info("checkSelfAuthByActivityDetail:{}", JSON.toJSONString(param));
        boolean flag = false;
        try {
            //查询列表
            flag = userService.checkSelfAuthByActivityDetail(param.getOpenId(),param.getId());
        } catch (Exception e) {
            logger.info("checkSelfAuthByActivityDetail error!",e);
            return new RespenseBean("FAIL", "error", "查询失败！");
        }
        return  new RespenseBean("SUCCESS", String.valueOf(flag), "查询成功！");
    }
}
