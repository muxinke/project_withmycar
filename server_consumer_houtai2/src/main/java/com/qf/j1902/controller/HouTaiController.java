package com.qf.j1902.controller;

import com.qf.j1902.service.UserService;
import com.qf.j1902.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 杜碧天 on 2019/7/4.
 */
@Controller
@RequestMapping("/houtai")
public class HouTaiController {
    @Autowired
    UserService userService;
    @RequestMapping("/user")
    public String user(Model model){

        List<UserVo> allUser = userService.findAllUser();

        System.out.println(allUser);
        model.addAttribute("users",allUser);
        return "user";
    }
}
