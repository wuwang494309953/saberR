package fgo.saber.zuul.shiro;

import com.google.common.collect.Sets;
import fgo.saber.authr.cloud.service.DTO.PermissionDTO;
import fgo.saber.authr.cloud.service.DTO.RoleDTO;
import fgo.saber.authr.cloud.service.DTO.UserDTO;
import fgo.saber.authr.cloud.service.PermissionCloudService;
import fgo.saber.authr.cloud.service.RoleCloudService;
import fgo.saber.authr.cloud.service.UserCloudService;
import fgo.saber.base.json.JsonResult;
import fgo.saber.shiro.interfaces.SaberUserService;
import fgo.saber.shiro.model.SbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zq
 * @date 2019/8/19
 */
@Service
public class SbUserServiceImpl implements SaberUserService {

    @Autowired
    private UserCloudService userCloudService;

    @Autowired
    private RoleCloudService roleCloudService;

    @Autowired
    private PermissionCloudService permissionCloudService;

    @Override
    public SbUser getUserInfoWithUsername(String username) {
        JsonResult<UserDTO> result = userCloudService.findUserWithUsername(username);
        if (result.getCode() != 0) {

        }
        UserDTO userDTO = result.getData();
        return SbUser.builder()
                .userId(userDTO.getUserId())
                .appId(userDTO.getAppId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build();
    }

    @Override
    public Set<String> getRolesWithUser(SbUser user) {
        JsonResult<List<RoleDTO>> result = roleCloudService.listWithAppAndUser(user.getAppId(), user.getUserId());
        if (result.getCode() != 0 ) {

        }
        Set<String> roles = Sets.newHashSet();
        for (RoleDTO roleDTO : result.getData()) {
            roles.add(roleDTO.getRoleValue());
        }
        return roles;
    }

    @Override
    public Set<String> getPermissions(SbUser user) {
        JsonResult<List<PermissionDTO>> result = permissionCloudService.listWithAppAndUser(user.getAppId(), user.getUserId());
        if (result.getCode() != 0) {

        }
        Set<String> permissions = result.getData().stream().map(permissionDTO -> permissionDTO.getPermissionValue()).collect(Collectors.toSet());
        return permissions;
    }


}
