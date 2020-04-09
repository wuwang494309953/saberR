package fgo.saber.shiro.filter;

import fgo.saber.base.statuscode.CommonStatusCode;
import fgo.saber.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author zq
 * @date 2020/4/9
 */
@Slf4j
public class SaberRolesAuthorizationFilter extends RolesAuthorizationFilter {


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {

        Subject subject = getSubject(request, response);
        // If the subject isn't identified, redirect to login URL
        if (subject.getPrincipal() == null) {
            //用户未登录
            log.trace("用户未登录");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(JsonMapper.obj2String(CommonStatusCode.NOT_LOGIN));
            return false;
        } else {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(JsonMapper.obj2String(CommonStatusCode.USER_NOT_ROLES));
        }
        return false;
    }

}
