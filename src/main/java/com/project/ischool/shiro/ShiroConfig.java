package com.project.ischool.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.project.ischool.shiro.redisCache.RedisCacheManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * @desc shiro配置类
 * @author  alancci
 * @date   2020/9/18 19:13
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         * 配置系统共用资源
         * 配置系统公共资源
         *    常用的过滤器：
         *       anon: 无需认证（登录）可以访问
         *       authc: 必须认证才可以访问
         *       user: 如果使用rememberMe的功能可以直接访问
         *       perms： 该资源必须得到资源权限才可以访问
         *       role: 该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap = new LinkedHashMap<String,String>();
//        filterMap.put("/add?", "authc");
//        filterMap.put("/update", "authc");
//        filterMap.put("/toRegister","anon");
//        filterMap.put("/register","anon");
//        filterMap.put("/loginview", "anon");
//        filterMap.put("/getImage", "anon");
//        filterMap.put("/login", "anon");
//        filterMap.put("/add", "perm[user:add:*]");
        filterMap.put("/*","anon ");
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");
        shiroFilterFactoryBean.setSuccessUrl("index");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultSecurityManager getSecurityManager(@Qualifier("userRealm") UserRealm userRealm){

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;

    }
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        //加密密码
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1024);
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        //用户领域设置缓存
        userRealm.setCacheManager(new RedisCacheManager());
        userRealm.setCachingEnabled(true);
        userRealm.setAuthenticationCachingEnabled(true);
        userRealm.setAuthenticationCacheName("authentication");
        userRealm.setAuthorizationCachingEnabled(true);
        userRealm.setAuthorizationCacheName("authorization");
        return userRealm;
    }
}
