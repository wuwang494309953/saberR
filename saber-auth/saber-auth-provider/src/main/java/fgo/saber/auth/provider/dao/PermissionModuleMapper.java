package fgo.saber.auth.provider.dao;

import fgo.saber.auth.provider.model.entity.PermissionModule;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionModuleMapper extends Mapper<PermissionModule> {

    List<PermissionModule> findPermissionModuleWithRoleId(Long roleId);

    @Select("select * from sb_permission_module where parent_id = #{parentId}")
    List<PermissionModule> findPermissionModuleWithParentId(Long parentId);
}