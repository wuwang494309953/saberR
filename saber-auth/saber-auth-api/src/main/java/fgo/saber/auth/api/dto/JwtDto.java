package fgo.saber.auth.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zq
 * @date 2018/10/19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtDto {

    private String jwt;

}
