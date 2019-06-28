package com.qf.j1902.managerServieTest;

import com.qf.j1902.pojo.Manager;
import com.qf.j1902.service.ManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2019/6/28.
 */
@Configuration("com.qf.j1902.service")
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestManager {
    @Autowired
    private ManagerService managerService;
    @Test
    public void test2(){
        Manager admin = managerService.queryManager("admin");
        System.out.println(admin);
    }
}
