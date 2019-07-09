package com.qf.j1902.service;

import com.github.pagehelper.PageInfo;
import com.qf.j1902.pojo.Manager;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/6/28.
 */
public interface ManagerService {
    //根据username查询用户信息
    public Manager queryManager(String username);
    //查询所有管理者信息
    ArrayList<Manager> queryAll(int pageNum,int pageSize);
}
