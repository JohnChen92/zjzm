package com.chzm.service.user;

import com.chzm.model.user.User;

import java.util.List;

public interface UserService {
    public List<User> loginAndCreate(User param);

    public List<User> queryUser(User user);

    public void UpdateUser(User user);

    boolean checkAdmin(String openId);

    boolean checkSelfAuthByJoinDetail(String openId,String activityJoinDetailId);

    boolean checkSelfAuthByActivityDetail(String openId, String id);
}
