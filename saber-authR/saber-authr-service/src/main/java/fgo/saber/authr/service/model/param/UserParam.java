package fgo.saber.authr.service.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zq
 * @date 2019/8/27
 */
@Data
public class UserParam {

    private Long userId;

    @NotNull(message = "appId不能为空")
    private Long appId;

    private String mail;

    private String telephone;

    @NotBlank(message = "username不能为空")
    private String username;

    @NotBlank(message = "password不能为空")
    private String password;

    private String remark;

    @NotNull(message = "status不能为空")
    private Integer status;

}
