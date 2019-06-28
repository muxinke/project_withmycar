package com.qf.j1902.config;

import com.qf.j1902.shiro.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/6/28.
 */
@Configuration
public class ShiroConfig {
    //注入MyReaml
    @Bean(name = "myRealm")
    public MyRealm getInstance(){
        return new MyRealm();
    }
    //构造安全管理器
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getSecurityManager(@Qualifier("myRealm")MyRealm myRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }
    //配置过滤器
    @Bean
    public ShiroFilterFactoryBean getShiroFilter(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        return shiroFilterFactoryBean;
    }
    //MD5加密
}
