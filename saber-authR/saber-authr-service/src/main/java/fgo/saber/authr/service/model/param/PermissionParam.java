package fgo.saber.authr.service.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zq
 * @date 2019/8/27
 */
@Data
public class PermissionParam {

    private Long permissionId;

    @NotNull(message = "appId不能为空")
    private Long appId;

    @NotBlank(message = "permissionName不能为空")
    private String permissionName;

    @NotBlank(message = "permissionValue不能为空")
    private String permissionValue;

    private String remark;

    @NotNull(message = "status不能为空")
    private Integer status;

}
