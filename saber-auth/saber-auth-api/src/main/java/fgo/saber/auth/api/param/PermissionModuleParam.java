package fgo.saber.auth.api.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zq
 * @date 2018/10/24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionModuleParam extends PageParam {

    private Long permissionModuleId;

    @NotNull(message = "父节点不能为空")
    private Long parentId;

    @NotBlank(message = "权限模块名不能为空")
    private String name;

    private String remark;

    private Integer seq;

    @NotNull(message = "权限状态不能为空")
    private Integer status;

}
