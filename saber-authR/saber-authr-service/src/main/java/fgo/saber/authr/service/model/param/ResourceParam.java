package fgo.saber.authr.service.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zq
 * @date 2019/8/27
 */
@Data
public class ResourceParam {

    private Long resourceId;

    @NotNull(message = "appId不能为空")
    private Long appId;

    @NotNull(message = "roleId不能为空")
    private Long roleId;

    @NotBlank(message = "resourceName不能为空")
    private String resourceName;

    @NotBlank(message = "resourceValue不能为空")
    private String resourceValue;

}
