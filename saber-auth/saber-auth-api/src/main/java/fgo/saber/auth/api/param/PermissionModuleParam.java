package fgo.saber.auth.api.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zq
 * @date 2018/10/24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionModuleParam {

    private Long permissionModuleId;

    private Long parentId;

    private String name;

    private String remark;

    private Integer seq;

    private Integer status;

}
