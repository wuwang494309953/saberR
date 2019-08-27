package fgo.saber.authr.service.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zq
 * @date 2019/8/27
 */
@Data
public class RoleParam {

    private Long roleId;

    @NotNull(message = "appId不能为空")
    private Long appId;

    @NotBlank(message = "roleName不能为空")
    private String roleName;

    private String remark;

    @NotNull(message = "status不能为空")
    private Integer status;

    @NotNull(message = "type不能为空")
    private Integer type;

}
