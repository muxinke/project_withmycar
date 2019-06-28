package com.qf.j1902.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/6/27.
 */
@RestController
public class HoutaiController {
    //后台登录显示页面
    @GetMapping("/index")
    public int index(){
        return 1;
    }
    //登录判断
    @PostMapping("/denglu")
    public int denglu(@RequestParam("username")String username,@RequestParam("password")String password){
        System.out.println("one");
        System.out.println(username);
        System.out.println(password);
        //利用shiro权限系统进行登录判断
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            if(subject.isAuthenticated()){
                //将登录用户存于session或者redis缓存数据库中
                return 1;  //校验成功
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return 2;  //验证失败
        }
        return -1;
    }
}
