package com.qf.j1902.service;

import com.qf.j1902.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by 杜碧天 on 2019/7/4.
 */
@FeignClient(value = "server-provider-two")
public interface UserService {
   @GetMapping("/user")
    public List<UserVo> findAllUser();
}
