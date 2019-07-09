package com.qf.j1902.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by 杜碧天 on 2019/7/9.
 */
@Data
public class UserVo {
    private long id;
    private String username;
    private String nickname;
    private String name;
    private String gender;
    private Date registerTime;
}
