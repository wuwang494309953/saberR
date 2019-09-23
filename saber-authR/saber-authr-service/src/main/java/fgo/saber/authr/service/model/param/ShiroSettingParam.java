package fgo.saber.authr.service.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zq
 * @date 2019/8/27
 */
@Data
public class ShiroSettingParam {

    private Long settingId;

    @NotNull(message = "appId不能为空")
    private Long appId;

    @NotBlank(message = "shiroPath不能为空")
    private String shiroPath;

    @NotBlank(message = "shiroAuth不能为空")
    private String shiroAuth;

    @NotNull(message = "orders不能为空")
    private Integer orders;

}
