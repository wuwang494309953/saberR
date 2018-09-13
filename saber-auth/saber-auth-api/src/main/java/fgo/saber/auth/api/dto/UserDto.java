package fgo.saber.auth.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zq
 * @date 2018/9/13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long userId;

    private Long deptId;

    private String mail;

    private Date operateTime;

    private String username;

    private String remark;

    private Integer status;

    private String telephone;
}
