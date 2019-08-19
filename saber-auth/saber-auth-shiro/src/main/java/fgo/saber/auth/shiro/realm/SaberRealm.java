package fgo.saber.auth.shiro.realm;

import com.google.common.collect.Sets;
import fgo.saber.auth.api.cloudservice.UserCloudService;
import fgo.saber.auth.api.dto.UserPasswordDto;
import fgo.saber.base.json.JsonResult;
import org.apache.shiro.authc.*;
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
    private UserCloudService userCloudService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String clientKey = (String) principals.getPrimaryPrincipal();
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
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        JsonResult<UserPasswordDto> userDtoJsonResult = userCloudService.findUserWithKeyWorld(token.getUsername());
        if (userDtoJsonResult == null || userDtoJsonResult.getCode() != 0) {
            throw new UnknownAccountException("用户: "+ token.getUsername() +"不存在");
        }
        return new SimpleAuthenticationInfo(userDtoJsonResult.getData(), userDtoJsonResult.getData().getPassword(), getName());
    }

}
