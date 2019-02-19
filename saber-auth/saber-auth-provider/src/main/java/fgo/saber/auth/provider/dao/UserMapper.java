package fgo.saber.auth.provider.dao;

import fgo.saber.auth.api.dto.UserDto;
import fgo.saber.auth.api.param.UserParam;
import fgo.saber.auth.provider.model.entity.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    @Select("select * from sb_user su where su.dept_id = #{deptId}")
    List<User> getUsersWithDeptId(Long deptId);

    @Select("select su.* from sb_user su inner join sb_user_role sur on su.user_id = sur.user_id where sur.role_id = #{roleId}")
    List<User> getUsersWithRoleId(Long roleId);

    List<UserDto> findUserList(UserParam userParam);

}