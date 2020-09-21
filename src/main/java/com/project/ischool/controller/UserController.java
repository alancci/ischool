package com.project.ischool.controller;


import com.project.ischool.entity.User;
import com.project.ischool.service.UserService;
import com.project.ischool.utils.DateUtils;
import com.project.ischool.utils.SaltUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Controller
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }



    @RequestMapping("/login")
    public String login(String username, String password, Model model,Integer rememberme, HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        System.out.println("login========="+password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        if (rememberme !=null && rememberme ==1){
            token.setRememberMe(true);
        }
        try {
          subject.login(token);
          logger.info(token.getPrincipal()+"登录了系统"+"登录时间"+ DateUtils.formateDate(request.getSession().getLastAccessedTime())+request.getRemoteAddr());
          return "index";
        }catch (UnknownAccountException uae){
            System.out.println("用户名不存在");
            model.addAttribute("msg","用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException ice){
            System.out.println(password);
            System.out.println("用户名或者密码错误");
            model.addAttribute("msg","用户名或者密码错误");
            return "login";
        }catch (LockedAccountException lae){
            System.out.println("账户被锁定");
            model.addAttribute("msg","账户被锁定");
            return "login";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }
    @RequestMapping("/register")
    public String register(String username,String password,Model model){
        Lock lock = new ReentrantLock();
        try {
            if (userService.findByUserName(username) == null){
                lock.lock();
                try{
                    User user = new User();
                    user.setUserName(username);
                    user.setPassword(password);
                    user.setCreateTime(new Date());
                    user.setIsEffected(1);
                    user.setIsEnabled(1);
                    userService.addUser(user);
                    System.out.println("注册成功");
                    return "redirect:/toLogin";
                }catch (Exception e){
                    e.printStackTrace();
                    return  "error";
                }finally {
                    lock.unlock();
                }

            }else {
                model.addAttribute("msgRegister","用户名已存在");
                return "register";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }





}
