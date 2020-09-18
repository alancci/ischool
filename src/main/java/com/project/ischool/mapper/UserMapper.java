package com.project.ischool.mapper;

import com.project.ischool.entity.User;

import java.util.List;

public interface UserMapper {
   // List<User> getUserList(User user, Integer page, Integer limit);
   // Integer getUserListCount(User user);
    void addUser(User user);
    User getUserById(Integer userId);
    void updateUser(User user);
    User getUser(User user);
    User getUserByNickName(User user);
    User findByRealName(User user);

}
