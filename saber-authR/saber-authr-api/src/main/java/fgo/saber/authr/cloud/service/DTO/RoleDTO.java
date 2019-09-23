package fgo.saber.authr.cloud.service.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author zq
 * @date 2019/9/23
 */
@Data
public class RoleDTO {

    private Long roleId;

    /**
     * appId
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long appId;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色值
     */
    private String roleValue;

    /**
     * 备注
     */
    private String remark;

    /**
     * 1-普通用户，2-管理员
     */
    private Integer type;

}
