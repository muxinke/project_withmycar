package com.qf.j1902.controller;

import com.qf.j1902.service.DengluService;
import com.qf.j1902.util.ImgCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Administrator on 2019/6/27.
 */
@Controller
public class HoutaiController {
    @Autowired
    private DengluService dengluService;
    @Autowired
    private ImgCode imgCode;
    @Autowired
    private Jedis jedis;
    //后台登录显示页面
    @GetMapping("index")
    public String index() {
        int index = dengluService.getIndex();
        if (index == 1) {
            return "houtailogin";
        }
        return "";
    }

    //获取验证码
    @GetMapping("/getImg")
    public void getImg(HttpServletRequest request, HttpServletResponse response) {
        imgCode.getRandcode(request, response);
    }

    //点击登录后，提交的控制器处理业务
    @PostMapping("/denglu")
    public String denglu(@RequestParam(value = "username", defaultValue = "") String username, @RequestParam(value = "password", defaultValue = "") String password,
                         @RequestParam("yanzhengma") String yanzhengma, HttpServletRequest request, Model model) {
        //先校验验证码是否相同
        String randomvalidatecodekey = jedis.get("yanzhengma");
        if (randomvalidatecodekey !=null) {
            if (randomvalidatecodekey.equalsIgnoreCase(yanzhengma)) {
                    //调用服务者1来完成业务功能
                    int result = dengluService.idDengLuSucess(username, password);
                    if (result == 1) {
                        System.out.println("成功");
                        return "main";
                    } else if (result == 2) {
                        model.addAttribute("tishi", "用户名或密码错误");
                        return "houtailogin";
                    }
                }
            }
            model.addAttribute("yanzhengmatishi", "验证码错误");
            return "houtailogin";
        }
        //后台系统管理界面显示
        @GetMapping("/main")
        public String main(){
            return "main";
        }
    }
