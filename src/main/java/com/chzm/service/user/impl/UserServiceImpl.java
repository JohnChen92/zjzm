package com.chzm.service.user.impl;

import com.alibaba.fastjson.JSON;
import com.chzm.dao.user.UserDao;
import com.chzm.model.avtivity.ActivityDetail;
import com.chzm.model.avtivity.ActivityJoinDetail;
import com.chzm.model.user.User;
import com.chzm.service.activity.ActivityService;
import com.chzm.service.user.UserService;
import com.chzm.utils.EmptyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private ActivityService activityService;


    @Override
    public List<User> loginAndCreate(User param) {
        List<User> list = userDao.queryUser(param);
        if(EmptyUtil.isEmpty(list)){
            userDao.insert(param);
            User user = new User();
            user.setOpenId(param.getOpenId());
            list = new ArrayList<User>();
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> queryUser(User user) {
        return userDao.queryUser(user);
    }

    @Override
    public void UpdateUser(User user) {
        userDao.updateByOpenId(user);
    }

    @Override
    public boolean checkAdmin(String openId) {
        User user = new User();
        user.setOpenId(openId);
        List<User> users = userDao.queryUser(user);
        if("ADMIN".equals(users.get(0).getRole())){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkSelfAuthByJoinDetail(String openId,String activityJoinDetailId) {
        if(checkAdmin(openId)){
            return true;
        }else{
            //openId查询user对应id
            User user = new User();
            user.setOpenId(openId);
            logger.info("loginUser:{}",JSON.toJSONString(user));
            List<User> list = userDao.queryUser(user);

            //活动中对应用户Id
            List<ActivityJoinDetail> joinDetails = activityService.queryActivityJoinDetailById(activityJoinDetailId);

            String joinId = joinDetails.get(0).getJoinUserId();
            String userId = list.get(0).getId();

            logger.info("checkSelfAuth joinId:{},userId:{}",joinId,userId);
            if(joinId.equals(userId)){
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public boolean checkSelfAuthByActivityDetail(String openId, String id) {
        if (checkAdmin(openId)) {
            return true;
        } else {
            //openId查询user对应id
            User user = new User();
            user.setOpenId(openId);
            logger.info("loginUser:{}", JSON.toJSONString(user));
            List<User> list = userDao.queryUser(user);

            //活动中对应用户Id
            List<ActivityDetail> joinDetails = activityService.queryActivityDetailById(id);

            String joinId = joinDetails.get(0).getCreateUserId();
            String userId = list.get(0).getId();

            logger.info("checkSelfAuthByActivityDetail joinId:{},userId:{}", joinId, userId);
            if (joinId.equals(userId)) {
                return true;
            } else {
                return false;
            }
        }
    }

}
