package fgo.saber.common.jwt;

import fgo.saber.commom.jwt.JwtUtil;
import org.junit.Test;

/**
 * @author zq
 * @date 2018/10/19
 */
public class JwtTest {

    @Test
    public void test1() {
        String token = JwtUtil.issueJwt("saber", "admin", 123L,"admin", "admin");
        System.out.println(token);
    }

}
