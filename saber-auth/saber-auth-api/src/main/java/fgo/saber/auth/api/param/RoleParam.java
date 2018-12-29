package fgo.saber.auth.api.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zq
 * @date 2018/10/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleParam {

    private Long roleId;

    @NotBlank(message = "角色名不能为空")
    private String name;

    private String remark;

    @Range(max = 1, message = "角色状态必须为0或1")
    private Integer status;

    @NotNull(message = "角色类型为不能为null")
    private Integer type;

}
