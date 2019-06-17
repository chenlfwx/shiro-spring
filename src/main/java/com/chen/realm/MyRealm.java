package com.chen.realm;

import com.chen.domain.User;
import com.chen.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Chen Dian
 * @date 2019/06/13
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    public String getName() {
        return "myRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        User user = userService.getByName(username);
        if (user == null) {
            return null;
        }
        ByteSource bytes = ByteSource.Util.bytes(username);// 加盐
        SimpleHash hash = new SimpleHash("MD5", user.getPassword(), bytes, 1024);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getName(), hash, bytes, getName());
        return info;
    }
}
