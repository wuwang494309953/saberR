package fgo.saber.auth.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

/**
 * @author zq
 * @date 2019/4/29
 */
@Data
public class PermissionModuleTreeDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long permissionModuleId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    private String name;

    private Integer seq;

    private String remark;

    private Integer status;

    private List<PermissionModuleTreeDto> child;

}
