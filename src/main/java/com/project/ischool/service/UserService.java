package com.project.ischool.service;

import com.project.ischool.entity.User;

import java.util.List;

public interface UserService {
    // List<User> getUserList(User user, Integer page, Integer limit);
     int addUser(User user);
     int updateUser(User user);
     List<User> queryAll();
     User findByUserName(String userName);
    int deleteUser(User user);
}
