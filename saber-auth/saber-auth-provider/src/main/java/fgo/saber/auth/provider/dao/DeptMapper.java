package fgo.saber.auth.provider.dao;

import fgo.saber.auth.api.dto.DeptDto;
import fgo.saber.auth.api.param.DeptParam;
import fgo.saber.auth.provider.model.entity.Dept;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

//@CacheNamespaceRef(DeptMapper.class)
public interface DeptMapper extends Mapper<Dept> {

    List<DeptDto> findDeptsWithParentId(Long parentId);

    List<Dept> getDeptFootWithDeptName(@Param("deptName") String deptName);

    List<DeptDto> findDeptDtoList(@Param("deptParam") DeptParam deptParam);

}