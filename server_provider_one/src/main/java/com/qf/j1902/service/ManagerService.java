package com.qf.j1902.service;

import com.qf.j1902.pojo.Manager;

/**
 * Created by Administrator on 2019/6/28.
 */
public interface ManagerService {
    //根据username查询用户信息
    public Manager queryManager(String username);
}
