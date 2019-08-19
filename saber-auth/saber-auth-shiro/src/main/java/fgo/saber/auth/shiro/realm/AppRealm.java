package fgo.saber.auth.shiro.realm;

import fgo.saber.auth.api.cloudservice.AppInfoCloudService;
import fgo.saber.auth.api.dto.AppInfoDto;
import fgo.saber.base.json.JsonResult;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zq
 * @date 2019/8/2
 */
public class AppRealm extends AuthorizingRealm {

    @Autowired
    private AppInfoCloudService appInfoCloudService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        JsonResult<AppInfoDto> appInfoDtoJsonResult = appInfoCloudService.getAppInfoWithId(Long.valueOf(token.getUsername()));
        if (appInfoDtoJsonResult == null || appInfoDtoJsonResult.getCode() != 0) {
            throw new UnknownAccountException("应用id: "+ token.getUsername() +"不存在");
        }
        return new SimpleAuthenticationInfo(appInfoDtoJsonResult.getData(), appInfoDtoJsonResult.getData().getAppSecret(), getName());
    }

}
