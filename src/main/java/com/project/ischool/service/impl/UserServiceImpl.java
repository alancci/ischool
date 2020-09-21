package com.project.ischool.service.impl;

import com.project.ischool.entity.User;
import com.project.ischool.mapper.UserMapper;
import com.project.ischool.service.UserService;
import com.project.ischool.utils.SaltUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @desc
 * @author  alancci
 * @date   2020/9/18 18:54
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int addUser(User user) {
        String salt = SaltUtils.getSalt(4);
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(user.getPassword(),salt,1024);
        user.setPassword(md5Hash.toHex());
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
