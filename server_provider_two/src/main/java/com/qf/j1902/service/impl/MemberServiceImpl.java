package com.qf.j1902.service.impl;

import com.qf.j1902.mapper.MemberMapper;
import com.qf.j1902.pojo.Member;
import com.qf.j1902.pojo.MemberExample;
import com.qf.j1902.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 杜碧天 on 2019/7/4.
 */
@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberMapper memberMapper;
    @Override
    public List<Member> findAll() {
        MemberExample memberExample = new MemberExample();
        List<Member> members = memberMapper.selectByExample(memberExample);
        System.out.println(members);
        return members;
    }
}
