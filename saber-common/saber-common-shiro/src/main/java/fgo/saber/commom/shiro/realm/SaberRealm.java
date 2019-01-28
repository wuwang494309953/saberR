package fgo.saber.commom.shiro.realm;

import com.google.common.collect.Sets;
import fgo.saber.auth.api.cloudservice.PermissionCloudService;
import fgo.saber.auth.api.cloudservice.RoleCloudService;
import fgo.saber.auth.api.cloudservice.UserCloudService;
import fgo.saber.auth.api.dto.PermissionDto;
import fgo.saber.auth.api.dto.RoleDto;
import fgo.saber.auth.api.dto.UserPasswordDto;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * @author zq
 * @date 2018/10/19
 */
public class SaberRealm extends AuthorizingRealm {

    @Autowired
    private UserCloudService userCloudService;

    @Autowired
    private RoleCloudService roleCloudService;

    @Autowired
    private PermissionCloudService permissionCloudService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        UserPasswordDto user = (UserPasswordDto) principalCollection.getPrimaryPrincipal();
        Set<String> permissionSet = Sets.newHashSet();
        Set<String> roleNameSet = Sets.newHashSet();

        List<RoleDto> roleDtos = roleCloudService.findRolesWithUserId(user.getUserId()).getData();
        if (CollectionUtils.isNotEmpty(roleDtos)) {
            roleDtos.forEach(roleDto -> roleNameSet.add(roleDto.getName()));
        }

        List<PermissionDto> permissionDtos = permissionCloudService.findPermissionsWithUserId(user.getUserId()).getData();
        if (CollectionUtils.isNotEmpty(permissionDtos)) {
            permissionDtos.forEach(permissionDto -> permissionSet.add(permissionDto.getUrl()));
        }

        info.addRoles(roleNameSet);
        info.addStringPermissions(permissionSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserPasswordDto user = userCloudService.findUserWithPhone(token.getUsername()).getData();
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}
