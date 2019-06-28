package com.qf.j1902.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2019/6/27.
 */
@Data
public class Manager implements Serializable{
    private int id;
    private String username;
    private String password;
    private String name;
    private String salt;
    private String phone;
    private String email;
    private boolean status;
    private Date create_time;
    private boolean is_super;
    private String consume;
    private String remark;
    private String dept;
}
