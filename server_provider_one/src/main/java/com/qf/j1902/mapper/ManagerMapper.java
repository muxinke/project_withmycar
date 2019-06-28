package com.qf.j1902.mapper;

import com.qf.j1902.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/6/28.
 */
@Mapper
public interface ManagerMapper {
    //根据username查询用户信息
    public Manager queryManager(@Param("username")String username);
    //查询所有管理者信息
    ArrayList<Manager> queryAll();

}
