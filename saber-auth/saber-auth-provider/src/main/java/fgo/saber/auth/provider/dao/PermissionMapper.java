package fgo.saber.auth.provider.dao;

import fgo.saber.auth.api.dto.PermissionDto;
import fgo.saber.auth.api.param.PermissionParam;
import fgo.saber.auth.provider.model.entity.Permission;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PermissionMapper extends Mapper<Permission> {

    List<PermissionDto> findPermissionList(PermissionParam permissionParam);

    @Select("select * from sb_permission where permission_module_id = #{permissionModuleId}")
    List<Permission> findPermissionWithModuleId(Long permissionModuleId);

    List<Permission> findPermissionWithUserId(Long userId);
}