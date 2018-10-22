package fgo.saber.auth.provider.shiro.filter;

import fgo.saber.commom.shiro.token.HmacToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author zq
 * @date 2018/10/19
 */
@Slf4j
public class HmacFilter extends AccessControlFilter {

    public static final String DEFAULT_CLIENTKEY_PARAM = "appId";
    public static final String DEFAULT_TIMESTAMP_PARAM = "timeStamp";
    public static final String DEFAUL_DIGEST_PARAM = "digest";

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        if (null != getSubject(servletRequest, servletResponse)
                && getSubject(servletRequest, servletResponse).isAuthenticated()) {
            //已经认证过直接放行
            return true;
        }
        //转到拒绝访问处理逻辑
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        //如果是Hmac鉴权的请求
        if(isHmacSubmission(servletRequest)){
            //创建令牌
            AuthenticationToken token = createToken(servletRequest, servletResponse);
            try {
                Subject subject = getSubject(servletRequest, servletResponse);
                //认证
                subject.login(token);
                //认证成功，过滤器链继续
                return true;
            } catch (AuthenticationException e) {
                //认证失败，发送401状态并附带异常信息
                log.error(e.getMessage(),e);
                WebUtils.toHttp(servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED,e.getMessage());
            }
        }
        //打住，访问到此为止
        return true;
    }

    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String clientKey = request.getParameter(DEFAULT_CLIENTKEY_PARAM);
        String timeStamp= request.getParameter(DEFAULT_TIMESTAMP_PARAM);
        String digest= request.getParameter(DEFAUL_DIGEST_PARAM);
        Map<String, String[]> parameters = request.getParameterMap();
        String host = request.getRemoteHost();
        return new HmacToken(clientKey, timeStamp, digest, parameters, host);
    }

    protected boolean isHmacSubmission(ServletRequest request) {
        String clientKey = request.getParameter(DEFAULT_CLIENTKEY_PARAM);
        String timeStamp= request.getParameter(DEFAULT_TIMESTAMP_PARAM);
        String digest= request.getParameter(DEFAUL_DIGEST_PARAM);
        return (request instanceof HttpServletRequest)
                && StringUtils.isNotBlank(clientKey)
                && StringUtils.isNotBlank(timeStamp)
                && StringUtils.isNotBlank(digest);
    }

}
