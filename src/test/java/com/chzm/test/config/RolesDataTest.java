package com.chzm.test.config;

import com.alibaba.fastjson.JSON;
import com.chzm.Application;
import com.chzm.dao.role.RoleDao;
import com.chzm.service.role.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.DispatcherServlet;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class RolesDataTest {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private DispatcherServlet dispatcherServlet;


    @Test
    public  void testDispatcherServlet(){

    }

    @Test
    public void testRolesData(){
        System.out.println(JSON.toJSONString(roleService.queryAllPlayRoles("openId")));
    }
}
