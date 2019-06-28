package com.qf.j1902.pojo;

import lombok.Data;

/**
 * Created by Administrator on 2019/6/27.
 */
@Data
public class Manager {
   /* `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `salt` varchar(128) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0��δ����\r\n            1������',
            `create_time` int(11) DEFAULT NULL,
  `is_super` tinyint(4) DEFAULT NULL COMMENT '0����ͨ����Ա\r\n            1����������Ա',
            `consumer` varchar(200) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `dept` varchar(200) DEFAULT NULL,*/
    private int id;
    private String username;
    private String password;
    private String name;
    private String salt;
    private String phone;
    private String email;
    private boolean status;
    private int create_time;
    private boolean is_super;
    private String consume;
    private String remark;
    private String dept;
}
