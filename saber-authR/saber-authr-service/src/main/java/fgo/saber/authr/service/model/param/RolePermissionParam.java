package fgo.saber.authr.service.model.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zq
 * @date 2019/9/20
 */
@Data
public class RolePermissionParam {

    @NotNull(message = "roleId不能为空")
    private Long roleId;

    private String permissionIds;

}
