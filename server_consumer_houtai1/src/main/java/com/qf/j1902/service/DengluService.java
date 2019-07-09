package com.qf.j1902.service;

import com.github.pagehelper.PageInfo;
import com.qf.j1902.pojo.Manager;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/6/27.
 */
@FeignClient(name = "server-provider-one")
public interface DengluService {
    @GetMapping("/index")
    public int getIndex();
    @PostMapping("/denglu")
    public int idDengLuSucess(@RequestParam("username")String username,@RequestParam("password")String password);
    @GetMapping("/admin")
    @ResponseBody
    public PageInfo<Manager> queryAll(@RequestParam("pageNum")int pageNum,@RequestParam("pageSize")int pageSize);
}
