package com.qf.j1902.controller;

import com.qf.j1902.util.ImgCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2019/7/9.
 */
@Controller
public class GetYanzhengmaController {
    @Autowired
    private ImgCode imgCode;
    //获取验证码服务
    @GetMapping("/getImg")
    public void getImg(HttpServletRequest request, HttpServletResponse response) {
        imgCode.getRandcode(request, response);
    }
}
