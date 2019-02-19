package fgo.saber.auth.api.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author zq
 * @Date 2018/9/19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserParam extends PageParam {

    private Long userId;

    @NotBlank(message = "部门id不能为空")
    private Long deptId;

    private String mail;

    @NotBlank(message = "用户名不可以为空")
    private String username;

    private String remark;

    @NotBlank(message = "用户状态不能为空")
    private Integer status;

    @NotBlank(message = "电话号码不能为空")
    private String telephone;

}
