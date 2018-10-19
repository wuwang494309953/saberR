package fgo.saber.auth.provider.dao;

import com.github.pagehelper.PageHelper;
import fgo.saber.auth.api.param.PageParam;
import fgo.saber.auth.api.param.UserParam;
import fgo.saber.auth.provider.ProviderApplicationTests;
import fgo.saber.auth.provider.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
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

        userParam.setUsername("ab");
        pageParam.setSortKey("username");
        pageParam.setSortValue("desc");

        PageHelper.startPage(2, 10, pageParam.sortStr());
        List result = userMapper.findUserList(userParam);
        log.info(String.valueOf(result.size()));
    }

    @Test
    public void saveUser() {
        for (int i = 0; i < 20; i++) {
            User user = User.builder()
                    .deptId(1L)
                    .username("saber")
                    .mail("231")
                    .status(1)
                    .telephone("456")
                    .operateTime(new Date())
                    .operateIp("127.0.0.0")
                    .operator("admin")
                    .build();
            userMapper.insert(user);
            log.info("插入对象: {}", user);
        }
    }

}
