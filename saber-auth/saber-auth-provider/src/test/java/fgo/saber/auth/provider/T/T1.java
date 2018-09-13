package fgo.saber.auth.provider.T;

import fgo.saber.auth.provider.ProviderApplicationTests;
import fgo.saber.auth.provider.dao.DeptMapper;
import fgo.saber.auth.provider.model.entity.Dept;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Slf4j
public class T1 extends ProviderApplicationTests {

    @Autowired
    private DeptMapper deptMapper;

    @Test
    @Transactional
    public void t1() {
        Dept dept = deptMapper.selectByPrimaryKey(236851946827382784L);
        Dept dept1 = deptMapper.selectByPrimaryKey(236851946827382784L);
        Dept dept2 = deptMapper.selectByPrimaryKey(236851946827382784L);

        log.info("查询对象: {}", dept);
        log.info("查询对象: {}", dept1);
        log.info("查询对象: {}", dept2);
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
        log.info("插入对象: {}", dept);
    }
}
