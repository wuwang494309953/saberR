package fgo.saber.auth.provider.shiro.realm;

import fgo.saber.auth.provider.model.entity.User;
import fgo.saber.auth.provider.service.impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zq
 * @date 2018/12/29
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.findUserWithName(token.getUsername());
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}
