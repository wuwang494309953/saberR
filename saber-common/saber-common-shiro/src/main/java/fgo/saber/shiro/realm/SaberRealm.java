package fgo.saber.shiro.realm;

import fgo.saber.shiro.interfaces.SaberUserService;
import fgo.saber.shiro.model.SbUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author zq
 * @date 2019/8/2
 */
public class SaberRealm extends AuthorizingRealm {

    @Autowired
    private SaberUserService saberUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SbUser user = (SbUser) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();

        // 根据客户标识（可以是用户名、app id等等） 查询并设置角色
        Set<String> roles = saberUserService.getRolesWithUser(user);
        if (roles != null) {
            info.setRoles(roles);
        }
        // 根据客户标识（可以是用户名、app id等等） 查询并设置权限
        Set<String> permissions = saberUserService.getPermissions(user);
        if (permissions != null) {
            info.setStringPermissions(permissions);
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SbUser user = saberUserService.getUserInfoWithUsername(token.getUsername());
        if (user == null) {
            throw new UnknownAccountException("用户: "+ token.getUsername() +"不存在");
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }

}
