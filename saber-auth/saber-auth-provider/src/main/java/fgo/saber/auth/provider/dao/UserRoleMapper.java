package fgo.saber.auth.provider.dao;

import fgo.saber.auth.provider.model.entity.UserRole;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserRoleMapper extends Mapper<UserRole> {

    @Select("select * from sb_user_role where role_id = #{roleId}")
    List<UserRole> findByRoleId(Integer roleId);
}