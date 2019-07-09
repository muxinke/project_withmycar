package com.qf.j1902.mapper;

import com.qf.j1902.pojo.MemberProfile;
import com.qf.j1902.pojo.MemberProfileExample;
import java.util.List;

import com.qf.j1902.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MemberProfileMapper {
    int countByExample(MemberProfileExample example);

    int deleteByExample(MemberProfileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberProfile record);

    int insertSelective(MemberProfile record);

    List<MemberProfile> selectByExample(MemberProfileExample example);

    MemberProfile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberProfile record, @Param("example") MemberProfileExample example);

    int updateByExample(@Param("record") MemberProfile record, @Param("example") MemberProfileExample example);

    int updateByPrimaryKeySelective(MemberProfile record);

    int updateByPrimaryKey(MemberProfile record);
    List<UserVo> findjm();
}