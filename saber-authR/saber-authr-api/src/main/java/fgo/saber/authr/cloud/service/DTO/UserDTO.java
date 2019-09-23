package fgo.saber.authr.cloud.service.DTO;

import lombok.Data;

/**
 * @author zq
 * @date 2019/9/23
 */
@Data
public class UserDTO {

    private Long userId;

    private Long appId;

    private String mail;

    private String telephone;

    private String username;

    private String password;

    private String remark;

}
