package fgo.saber.auth.provider.dao;

import fgo.saber.auth.api.param.PageParam;
import fgo.saber.auth.api.param.UserParam;
import fgo.saber.auth.provider.ProviderApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zq
 * @date 2018/10/16
 */
@Slf4j
public class UserMapperTest extends ProviderApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUsersWithDeptId() {
        List result = userMapper.getUsersWithDeptId(123L);
        log.info(String.valueOf(result.size()));
    }

    @Test
    public void findUserList() {
        UserParam userParam = new UserParam();
        PageParam pageParam = new PageParam();

        userParam.setUsername("三");
        pageParam.setSortKey("username");
        pageParam.setSortValue("desc");
        List result = userMapper.findUserList(userParam, pageParam);
        log.info(String.valueOf(result.size()));
    }

}
