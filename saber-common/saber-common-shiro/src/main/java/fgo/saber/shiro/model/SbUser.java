package fgo.saber.shiro.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author zq
 * @date 2019/8/19
 */
@Data
@Builder
public class SbUser {

    private Long userId;

    private String username;

    private String password;

}
