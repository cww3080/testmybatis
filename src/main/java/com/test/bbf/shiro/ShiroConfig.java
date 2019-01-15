package com.test.bbf.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);


        //默认跳转到登陆页面
        shiroFilterFactoryBean.setLoginUrl("/test/nopower");
        //登陆成功后的页面
        //shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/test/error");


        //自定义过滤器
        //Map<String,Filter> filterMap=new LinkedHashMap<>();
        //shiroFilterFactoryBean.setFilters(filterMap);
        //权限控制map
        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<>();
        // 配置不会被拦截的链接 顺序判断
        //filterChainDefinitionMap.put("/product/**", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        //filterChainDefinitionMap.put("/test/productHtml", "anon");
        //filterChainDefinitionMap.put("/test/addproduct", "authc");
        //filterChainDefinitionMap.put("/test/**product", "authc");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问；user：如果使用rememberMe的功能可以直接访问；perms：该资源必须得到资源权限才可以访问；role：该资源必须得到角色权限才可以访问-->
        filterChainDefinitionMap.put("/**", "anon");

        //授权过滤器
        //filterChainDefinitionMap.put("/test/productHtml", "perms[product:select]");
        //filterChainDefinitionMap.put("/test/addproduct", "perms[product:add]");
        //filterChainDefinitionMap.put("/test/updateproduct", "perms[product:update]");

        //shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realmz（完成认证与授权的操作）
     */
    @Bean("userRealm")
    public UserRealm getrealm(){
        return new UserRealm();
    }

    /**
     * 配置ShiroDialect，用于thymeleft和shiro标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
