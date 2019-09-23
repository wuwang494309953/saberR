package fgo.saber.authr.cloud.service.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class AppShiroSettingDTO {
    /**
     * 配置id
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long settingId;

    /**
     * appId
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long appId;

    /**
     * shiro的权限eg.(/test/*,/**)这样的路径
     */
    private String shiroPath;

    /**
     * shiro中的权限。eg(authc,anon)
     */
    private String shiroAuth;


}