package fgo.saber.authr.service.model.vo;

import fgo.saber.authr.service.model.entity.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zq
 * @date 2019/9/18
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleVO extends Role {

    private String appName;

}
