package fgo.saber.auth.api.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zq
 * @date 2018/10/24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionParam {

    private Long permissionId;

    private Long permissionModuleId;

    private String name;

    private String remark;

    private Integer seq;

    private Integer status;

    private Integer type;

    private String url;

}
