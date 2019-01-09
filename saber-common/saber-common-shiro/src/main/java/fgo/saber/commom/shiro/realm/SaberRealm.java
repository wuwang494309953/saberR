package fgo.saber.commom.shiro.realm;

import fgo.saber.auth.api.cloudservice.UserCloudService;
import fgo.saber.auth.api.dto.UserPasswordDto;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zq
 * @date 2018/10/19
 */
public class SaberRealm extends AuthorizingRealm {

    @Autowired
    private UserCloudService userCloudService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserPasswordDto user = (UserPasswordDto) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserPasswordDto user = userCloudService.findUserWithName(token.getUsername()).getData();
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}
