package fgo.saber.authr.cloud.service.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author zq
 * @date 2019/9/23
 */
@Data
public class PermissionDTO {

    private Long permissionId;

    /**
     * appId
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long appId;

    private String permissionName;

    private String permissionValue;

    private String remark;

}
