package com.test.bbf.shiro;

import com.test.bbf.entity.SysUser;
import com.test.bbf.entity.UserPower;
import com.test.bbf.service.SysUserService;
import com.test.bbf.service.UserPowerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义realm
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private UserPowerService userPowerService;

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑！");

        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();
        SysUser user = (SysUser)subject.getPrincipal();
        UserPower power = userPowerService.getPowerByName(user.getLoginname());
        String[] ps = power.getPowerlist().split(";");
        //添加资源的授权字符串
        //info.addStringPermission("product:select");
        List<String> perms = new ArrayList<String>();
        for(String perm : ps){
            System.out.println(perm);
            perms.add(perm);
        }
        perms.add("product:select");
        //perms.add("product:add");
        //perms.add("product:update");
        info.addStringPermissions(perms);
        return info;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑！");

        //编写shiro判断逻辑，判断用户名和密码
        //1、判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        SysUser user = sysUserService.getUserByName(token.getUsername());

        if (user == null || !token.getUsername().equals(user.getLoginname())){
            //用户名不存在
            return null;    //shiro底层会抛出UnknownAccountException异常。
        }

        //2、判断密码
        //第一个参数：返回的消息，第二个数据库中的密码，第三个realmName
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
