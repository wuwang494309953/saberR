package fgo.saber.auth.api.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zq
 * @Date 2018/9/19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserParam {

    private Long userId;

    private Long deptId;

    private String mail;

    private Date operateTime;

    private String username;

    private String remark;

    private Integer status;

    private String telephone;

}
