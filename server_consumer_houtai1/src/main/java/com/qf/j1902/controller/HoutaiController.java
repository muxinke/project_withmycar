package com.qf.j1902.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.j1902.pojo.Manager;
import com.qf.j1902.service.DengluService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by Administrator on 2019/6/27.
 */
@RequestMapping("/houtai")
@Controller
public class HoutaiController {
    @Autowired
    private DengluService dengluService;
   /* @Autowired
    private ImgCode imgCode;*/
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

    /*//获取验证码
    @GetMapping("/getImg")
    public void getImg(HttpServletRequest request, HttpServletResponse response) {
        imgCode.getRandcode(request, response);
    }*/

    //点击登录后，提交控制器处理业务
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
                        return "redirect:http://localhost:10030/houtai/houtai/main";
                    } else if (result == 2) {
                        model.addAttribute("tishi", "用户名或密码错误");
                        //return "reditect:http://localhost:10011/houtai/houtai/index";
                        return "houtailogin";
                    }
                }
            }
            model.addAttribute("yanzhengmatishi", "验证码错误");
           // return "forward:http://localhost:10011/houtai/houtai/index";
              return "houtailogin";
        }
        //后台系统管理界面显示
        @GetMapping("/main")
        public String main(){
            return "main";
        }
        //后台管理者界面
        /*
        *从前台传入当前页数的参数  从参数管理查询每页的显示行数
        */
        @GetMapping("/admin")
        public String admin(HttpServletRequest request, Model model,
                            @RequestParam(value="pageNum",defaultValue="1")int pageNum){
            //将来从参数管理获取
            int pageSize =2;
            //调用服务者1完成所有管理者信息的查询
            //PageHelper.startPage(1,5);
            PageInfo<Manager> managerPageInfo =dengluService.queryAll(pageNum,pageSize);

            model.addAttribute("pageInfo",managerPageInfo);

            return "admin";
        }
        //管理员新增界面
        @GetMapping("/addadmin")
        public String addadmin(){
            //从数据库查出所有角色，返回前台
            return "addadmin";
        }
        //保存增加的管理员
    @PostMapping("/save")
    public String save(@RequestParam(value = "username",defaultValue = "")String username,
                       @RequestParam(value = "password",defaultValue = "")String password,
                       @RequestParam(value = "name",defaultValue = "")String name,
                       @RequestParam(value = "phone",defaultValue = "")String phone,
                       @RequestParam(value = "email",defaultValue = "")String email,
                       @RequestParam(value = "remark",defaultValue = "")String remark,
                       @RequestParam(value = "role",defaultValue = "")int role,
                       @RequestParam(value = "dept",defaultValue = "")String dept){
            if("".equals(username)||"".equals(password)||"".equals(name)||"".equals(phone)||
                    "".equals(email)||"".equals(remark)||"".equals(dept)){
                return "redirect:http://localhost:10030/houtai/houtai/addadmin";
            }
            //调用服务者1完成保存资料功能

            return null;
    }
    }
