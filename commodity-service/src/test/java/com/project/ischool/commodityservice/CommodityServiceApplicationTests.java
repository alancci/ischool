package com.project.ischool.commodityservice;

import com.project.ischool.entity.User;
import com.project.ischool.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class CommodityServiceApplicationTests {

    @Reference
    private UserService userService;

    @Test
    void contextLoads() {
    }

    public UserService getUserService() {
        return userService;
    }
    @Test
    public void test(){
        List<User> users = userService.queryAll();
        for (User user:users) {
            System.out.println(user);
        }


    }
}
