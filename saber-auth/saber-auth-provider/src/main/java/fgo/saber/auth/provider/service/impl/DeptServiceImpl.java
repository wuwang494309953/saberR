package fgo.saber.auth.provider.service.impl;

import fgo.saber.auth.provider.dao.DeptMapper;
import fgo.saber.auth.provider.model.entity.Dept;
import fgo.saber.common.abst.AbstBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author zq
 * @Date 2018/9/11
 */
@Service
public class DeptServiceImpl extends AbstBaseService<Dept> {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Mapper<Dept> getDao() {
        return deptMapper;
    }

    public List<Dept> getDeptsWithParentId(Long parentId) {
        return deptMapper.findDeptsWithParentId(parentId);
    }

}