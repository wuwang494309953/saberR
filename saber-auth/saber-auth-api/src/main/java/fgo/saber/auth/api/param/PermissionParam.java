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
public class PermissionParam extends PageParam {

    private Long permissionId;

    @NotNull(message = "权限所属模块不能为空")
    private Long permissionModuleId;

    @NotBlank(message = "权限名不能为空")
    private String name;

    private String remark;

    private Integer seq;

    @NotNull(message = "权限状态不能为空")
    private Integer status;

    @NotNull(message = "权限类型不能为空")
    private Integer type;

    private String url;

}
