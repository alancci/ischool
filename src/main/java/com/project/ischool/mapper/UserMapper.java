package com.project.ischool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.ischool.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface UserMapper  {
   // List<User> getUserList(User user, Integer page, Integer limit);
   // Integer getUserListCount(User user);
//    void addUser(User user);
//    User getUserById(Integer userId);
//    void updateUser(User user);
//    User getUser(User user);
//    User getUserByNickName(User user);
//    User findByRealName(User user);
    List<User> queryAll();
    User findByUserName(String userName);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(User user);
}
