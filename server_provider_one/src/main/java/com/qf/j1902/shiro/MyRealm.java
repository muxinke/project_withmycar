package com.qf.j1902.shiro;

import com.qf.j1902.pojo.Manager;
import com.qf.j1902.service.ManagerService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2019/6/28.
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private ManagerService managerService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    //登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        Object principal = authenticationToken.getPrincipal();
        String username =(String)principal;
        //根据username查询用户信息
        Manager manager = managerService.queryManager(username);
        SimpleAuthenticationInfo simpleAuthenticationInfo =null;
        if(manager!=null){
            simpleAuthenticationInfo=new SimpleAuthenticationInfo(username,manager.getPassword(),this.getName());
            System.out.println(simpleAuthenticationInfo);
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
