package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.ManagerMapper;
import com.qf.j1902.pojo.Manager;
import com.qf.j1902.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.helpers.ParseConversionEventImpl;
import java.util.ArrayList;

/**
 * Created by Administrator on 2019/6/28.
 */
@Service
public class ManagerServiceImpl implements ManagerService{
    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public Manager queryManager(String username) {
        return managerMapper.queryManager(username);
    }

    @Override
    public ArrayList<Manager> queryAll() {
        return managerMapper.queryAll();
    }
}
