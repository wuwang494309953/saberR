package fgo.saber.auth.api.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zq
 * @Date 2018/9/21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPageParam {

    private UserParam userParam;

    private BasePageParam pageParam;

}
