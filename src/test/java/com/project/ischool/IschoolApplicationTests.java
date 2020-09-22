package com.project.ischool;

import com.project.ischool.entity.User;
import com.project.ischool.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
class IschoolApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
    }


    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testUserMapper(){
        Jedis jedis = new Jedis("192.168.1.178", 6379);
        jedis.set("21","23");
        User user1 = new User();
        user1.setUserId(123);
        user1.setUserName("222333");
        user1.setCreateTime(new Date());
        System.out.println(("----- selectAll method test ------"));
//        List<User> userList = userMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
//        userList.forEach(System.out::println);
//        userMapper.addUser(user1);
//        userMapper.updateUser(user1);
//        userMapper.deleteUser(user1);
        List<User> userList = userMapper.queryAll();
        for (User user: userList) {
            System.out.println(user);
        }
    }

}
