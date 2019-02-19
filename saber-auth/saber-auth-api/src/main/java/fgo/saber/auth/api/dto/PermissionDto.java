package fgo.saber.auth.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zq
 * @date 2019/1/28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long permissionId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long permissionModuleId;

    private String name;

    private String operateIp;

    private Date operateTime;

    private String operator;

    private String remark;

    private Integer seq;

    private Integer status;

    private Integer type;

    private String url;

}
