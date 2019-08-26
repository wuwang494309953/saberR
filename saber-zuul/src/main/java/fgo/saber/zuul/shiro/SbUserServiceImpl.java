package fgo.saber.zuul.shiro;

import com.google.common.collect.Sets;
import fgo.saber.shiro.interfaces.SaberUserService;
import fgo.saber.shiro.model.SbUser;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author zq
 * @date 2019/8/19
 */
@Service
public class SbUserServiceImpl implements SaberUserService {

    @Override
    public SbUser getUserInfoWithUsername(String username) {

        return SbUser.builder()
                .userId(1L)
                .username("saber")
                .password("123456")
                .build();
    }

    @Override
    public Set<String> getRolesWithUser(SbUser user) {
        return null;
    }

    @Override
    public Set<String> getPermissions(SbUser user) {
        Set<String> permissions = Sets.newHashSet();
        permissions.add("test1");
        return permissions;
    }


}
