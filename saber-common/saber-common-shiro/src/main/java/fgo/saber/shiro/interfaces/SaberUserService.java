package fgo.saber.shiro.interfaces;

import fgo.saber.shiro.model.SbUser;

import java.util.Set;

/**
 * @author zq
 * @date 2019/8/19
 */
public interface SaberUserService {

    /**
     * 根据用户名获取用户信息，根据情况这里也可以是邮箱，电话号码
     * @param username
     * @return
     */
    SbUser getUserInfoWithUsername(String username);

    /**
     * 根据用户获取用户的角色
     * @param user
     * @return
     */
    Set<String> getRolesWithUser(SbUser user);

    /**
     * 根据用户获取用户的权限
     * @param user
     * @return
     */
    Set<String> getPermissions(SbUser user);

}
