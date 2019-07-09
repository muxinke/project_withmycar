package com.qf.j1902.controller;

import com.qf.j1902.service.MemberProfileService;
import com.qf.j1902.service.MemberService;
import com.qf.j1902.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 杜碧天 on 2019/7/4.
 */
@RestController
public class HouTaicontroller {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberProfileService memberProfileService;
    @RequestMapping("/user")
    public List<UserVo> user(){
        List<UserVo> alljm = memberProfileService.findAlljm();
        return alljm;
    }
}
