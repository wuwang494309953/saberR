package fgo.saber.authr.service.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zq
 * @date 2019/8/27
 */
@Data
public class GatewaySettingParam {

    private Long gatewayId;

    @NotNull(message = "appId不能为空")
    private Long appId;

    @NotBlank(message = "appServiceId不能为空")
    private String appServiceId;

    @NotBlank(message = "gatewayPath不能为空")
    private String gatewayPath;

}
