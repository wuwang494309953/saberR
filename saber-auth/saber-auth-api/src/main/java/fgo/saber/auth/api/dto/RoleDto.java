package fgo.saber.auth.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zq
 * @date 2019/1/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private Long roleId;

    private String name;

    private String operateIp;

    private Date operateTime;

    private String operator;

    private String remark;

    private Integer status;

    private Integer type;

}
