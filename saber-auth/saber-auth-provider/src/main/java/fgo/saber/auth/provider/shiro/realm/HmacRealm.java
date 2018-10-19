package fgo.saber.auth.provider.shiro.realm;

import com.google.common.collect.Sets;
import fgo.saber.auth.provider.service.impl.UserServiceImpl;
import fgo.saber.commom.shiro.token.HmacToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author zq
 * @date 2018/10/19
 */
public class HmacRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public Class getAuthenticationTokenClass() {
        return HmacToken.class;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String clientKey = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        // 根据客户标识（可以是用户名、app id等等） 查询并设置角色
        Set<String> roles = Sets.newHashSet();
        info.setRoles(roles);
        // 根据客户标识（可以是用户名、app id等等） 查询并设置权限
        Set<String> permissions = Sets.newHashSet();
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        HmacToken hmacToken = (HmacToken)token;
        String digest = hmacToken.getDigest();
        return new SimpleAuthenticationInfo(hmacToken, digest, getName());
    }
}
