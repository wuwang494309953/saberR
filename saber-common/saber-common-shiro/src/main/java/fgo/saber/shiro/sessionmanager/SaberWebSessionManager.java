package fgo.saber.shiro.sessionmanager;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @author zq
 * @date 2019/8/2
 */
public class SaberWebSessionManager extends DefaultWebSessionManager {

    public static final String AUTH_HEAD = "Authorization";

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        // 从请求头中获取token
        String token = WebUtils.toHttp(request).getHeader(AUTH_HEAD);
        // 判断是否有值
        if (StringUtils.isNoneBlank(token)) {
            // 设置当前session状态
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "url");
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, token);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return token;
        }
        return super.getSessionId(request, response);
    }
}
