package com.qf.j1902.service;

import com.qf.j1902.vo.UserVo;

import java.util.List;

/**
 * Created by 杜碧天 on 2019/7/9.
 */
public interface MemberProfileService {
    //会员展示界面
    List<UserVo> findAlljm();
}
