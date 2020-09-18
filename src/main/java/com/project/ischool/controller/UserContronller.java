package com.project.ischool.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserContronller {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
