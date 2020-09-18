package com.project.ischool.service.impl;

import com.project.ischool.entity.User;
import com.project.ischool.mapper.UserMapper;
import com.project.ischool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @desc
 * @author  alancci
 * @date   2020/9/18 18:54
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.queryAll();
    }

    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    public int deleteUser(User user) {
        return userMapper.deleteUser(user);
    }
}
