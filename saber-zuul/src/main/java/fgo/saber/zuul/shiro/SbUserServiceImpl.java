package fgo.saber.zuul.shiro;

import com.google.common.collect.Sets;
import fgo.saber.authr.cloud.service.DTO.UserDTO;
import fgo.saber.authr.cloud.service.UserCloudService;
import fgo.saber.base.json.JsonResult;
import fgo.saber.shiro.interfaces.SaberUserService;
import fgo.saber.shiro.model.SbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author zq
 * @date 2019/8/19
 */
@Service
public class SbUserServiceImpl implements SaberUserService {

    @Autowired
    private UserCloudService userCloudService;

    @Override
    public SbUser getUserInfoWithUsername(String username) {
        JsonResult<UserDTO> result = userCloudService.findUserWithUsername(username);
        if (result.getCode() != 0) {

        }
        UserDTO userDTO = result.getData();
        return SbUser.builder()
                .userId(userDTO.getUserId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build();
    }

    @Override
    public Set<String> getRolesWithUser(SbUser user) {
        Set<String> roles = Sets.newHashSet();
        roles.add("boy");
        return roles;
    }

    @Override
    public Set<String> getPermissions(SbUser user) {
        Set<String> permissions = Sets.newHashSet();
        permissions.add("boy");
        return permissions;
    }


}
