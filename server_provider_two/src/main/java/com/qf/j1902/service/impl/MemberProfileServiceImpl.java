package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.MemberProfileMapper;
import com.qf.j1902.service.MemberProfileService;
import com.qf.j1902.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜碧天 on 2019/7/9.
 */
@Service
public class MemberProfileServiceImpl implements MemberProfileService{
    @Autowired
    MemberProfileMapper memberProfileMapper;


    @Override
    public List<UserVo> findAlljm() {
        ArrayList<UserVo> objects = new ArrayList<>();
        List<UserVo> findjm = memberProfileMapper.findjm();
        /* for(UserVo userVo:findjm){
             userVo.getRegisterTime()
         }*/
        return findjm;
    }
}
