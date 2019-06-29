package com.qf.j1902.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.j1902.pojo.Manager;
import com.qf.j1902.service.DengluService;
import com.qf.j1902.util.ImgCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


/**
 * Created by Administrator on 2019/6/27.
 */
@RequestMapping("/houtai")
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
        //后台管理者界面
        @GetMapping("/admin")
        public String admin(HttpServletRequest request, Model model,
                            @RequestParam(value="pageNum",defaultValue="1")int pageNum, @RequestParam(value="pageSize",defaultValue="5")int pageSize){
            //调用服务者1完成所有管理者信息的查询

            //PageHelper.startPage(pageNum,5);
            System.out.println(pageNum);
            System.out.println(pageSize);
            PageHelper.startPage(1,5);
            ArrayList<Manager> managers =dengluService.queryAll();
            PageInfo<Manager> managerPageInfo =new PageInfo<>(managers);
            System.out.println(managerPageInfo.getPageSize());
            model.addAttribute("pageInfo",managerPageInfo);
       /*     System.out.println(managers);
            request.getSession().setAttribute("users",managers);
            //model.addAttribute("users",users);
            PageInfo<Manager> userPageInfo = new PageInfo<>(managers, 5);
            model.addAttribute("pageInfo",userPageInfo);
            //获得当前页
            model.addAttribute("pageNum",userPageInfo.getPageNum());
            System.out.println(userPageInfo.getPageNum());
            //获得一页显示的条数
            model.addAttribute("pageSize",5);
            //判断是否为第一页
            model.addAttribute("isFirstPage",userPageInfo.isIsFirstPage());
            //获得总页数
            model.addAttribute("totalPages",userPageInfo.getPages());
            System.out.println(userPageInfo.getPages());
            //是否是最后一页
            model.addAttribute("isLastPage",userPageInfo.isIsLastPage());*/
            return "admin";
        }
        //管理员新增界面
        @GetMapping("/addadmin")
        public String addadmin(){
            return "addadmin";
        }
    }
