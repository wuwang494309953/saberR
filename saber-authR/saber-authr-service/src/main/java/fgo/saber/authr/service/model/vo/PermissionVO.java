package fgo.saber.authr.service.model.vo;

import fgo.saber.authr.service.model.entity.Permission;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zq
 * @date 2019/9/19
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PermissionVO extends Permission {

    private String appName;

}
