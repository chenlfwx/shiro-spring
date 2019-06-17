package com.chen.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Chen Dian
 * @date 2019/06/13
 */
@Controller
public class LoginController {

    @PostMapping("/shiro/login")
    @ResponseBody
    public String login(String username,String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return "success";
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "fail";
    }
}
