package com.xinruiyun.platform.shiro.realm;

import com.xinruiyun.platform.entity.user.UserInfo;
import com.xinruiyun.platform.service.user.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    /*
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String userName = (String) principals.fromRealm(getName()).iterator().next();
        if(userName != null){
            // 查询用户授权信息
            UserInfo userInfo = userService.queryUserByUsername(userName);
            if( userInfo != null){

//                return info;
            }
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(null);
        authorizationInfo.setStringPermissions(null);
        return authorizationInfo;
    }

    /*
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // TODO Auto-generated method stub
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        String username = upToken.getUsername();
        String password = String.valueOf(upToken.getPassword());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password .toCharArray(),getName());
        return info;
    }
}
