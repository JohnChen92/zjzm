package com.chzm.dao.user;

import com.chzm.model.user.User;

import java.util.List;

public interface UserDao {

    void insert (User user);
    List<User> queryUser (User user);
    void updateByOpenId (User user);
}