package fgo.saber.auth.provider.dao;

import fgo.saber.auth.provider.model.entity.Dept;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DeptMapper extends Mapper<Dept> {

    List<Dept> findDeptsWithParentId(Long parentId);

}