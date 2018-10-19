package fgo.saber.commom.shiro.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.shiro.authc.AuthenticationToken;

import java.util.Map;

/**
 * @author zq
 * @date 2018/10/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HmacToken implements AuthenticationToken {

    private static final long serialVersionUID = 5658582366708677777L;
    /**
     * 客户标识（可以是用户名、app id等等）
     */
    private String appId;
    /**
     * 消息摘要
     */
    private String digest;
    /**
     * 时间戳
     */
    private String timeStamp;
    /**
     * 访问参数
     */
    private Map<String, String[]> parameters;
    /**
     * 客户端IP
     */
    private String host;

    @Override
    public Object getPrincipal() {
        return this.appId;
    }

    @Override
    public Object getCredentials() {
        return true;
    }
}
