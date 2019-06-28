package com.qf.j1902.service;

import com.qf.j1902.pojo.Manager;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/6/27.
 */
@FeignClient(value = "server-provider-one")
public interface DengluService {
    @GetMapping("/index")
    public int getIndex();
    @PostMapping("/denglu")
    public int idDengLuSucess(@RequestParam("username")String username,@RequestParam("password")String password);
    @GetMapping("/admin")
    public ArrayList<Manager> queryAll();
}
