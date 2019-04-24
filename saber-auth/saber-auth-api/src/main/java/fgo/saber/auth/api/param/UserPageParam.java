package fgo.saber.auth.api.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zq
 * @date 2019/4/24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPageParam extends PageParam {

    private Long userId;

    private Long deptId;

    private String mail;

    private String username;

    private String remark;

    private Integer status;

    private String telephone;



}
