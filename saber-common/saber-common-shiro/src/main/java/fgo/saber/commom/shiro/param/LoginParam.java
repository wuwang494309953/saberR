package fgo.saber.commom.shiro.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zq
 * @date 2019/1/3
 */
@Data
public class LoginParam {

    @NotBlank(message = "用户名不能为空")
    public String username;

    @NotBlank(message = "密码不能为空")
    public String password;

}
