package fgo.saber.authr.service.model.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zq
 * @date 2019/9/19
 */
@Data
public class UserRoleParam {

    @NotNull(message = "userId不能为空")
    private Long userId;

    private String roleIds;

}
