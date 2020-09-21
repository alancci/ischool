package com.project.ischool.shiro;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.project.ischool.entity.User;
import com.project.ischool.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;

/**
 * @desc
 * @author  alancci
 * @date   2020/9/18 19:15
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    @Qualifier("slaveRedisTemplate")
    private RedisTemplate slaveRedisTemplate;

    private String userCache = "userCache";


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //主体
        Subject subject = SecurityUtils.getSubject();
        //认证token
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String principal = (String) token.getPrincipal();
        User user = new User();
        if(slaveRedisTemplate.opsForHash().get(userCache,principal)==null){
            user = userService.findByUserName(principal);
        }else {
            String userString = (String) slaveRedisTemplate.opsForHash().get(userCache,principal);
            //将存储的json转换成java对象使用 JSON类下的静态方法 将java对象转成成json等操作使用JSONObject类提供的静态方法
            user = JSON.parseObject(userString,User.class);
            System.out.println(user+"====================");
        }
        if (ObjectUtils.isEmpty(user)){
            return null;
        }
        return new SimpleAuthenticationInfo(principal,user.getPassword(), new MyByteSource(user.getSalt()),this.getName());
    }
}
