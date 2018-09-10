package fgo.saber.auth.provider.T;

import fgo.saber.auth.provider.ProviderApplicationTests;
import fgo.saber.auth.provider.dao.DeptMapper;
import fgo.saber.auth.provider.model.entity.Dept;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

public class T1 extends ProviderApplicationTests {

    @Resource
    private DeptMapper deptMapper;

    @Test
    public void t1() {
        Dept dept = deptMapper.selectByPrimaryKey(1L);
        System.out.printf(dept.getName());
    }

    @Test
    public void insert1() {
        Dept dept = Dept.builder()
                .name("研发部")
                .operator("admin")
                .operateIp("1239.1.1.1")
                .operateTime(new Date())
                .parentId(0L)
                .seq(1)
                .build();
        deptMapper.insert(dept);
        System.out.println(dept);
    }
}
