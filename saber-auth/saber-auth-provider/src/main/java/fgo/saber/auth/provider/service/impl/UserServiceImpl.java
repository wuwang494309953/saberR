package fgo.saber.auth.provider.service.impl;

import com.google.common.base.Preconditions;
import fgo.saber.auth.provider.dao.UserMapper;
import fgo.saber.auth.provider.model.entity.User;
import fgo.saber.common.abst.AbstBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Saber
 * @Date 2018/10/16
 */
@Service
public class UserServiceImpl extends AbstBaseService<User> {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Mapper<User> getDao() {
        return userMapper;
    }


    public List<User> getUsersWithDeptId(Long deptId) {
        Preconditions.checkNotNull(deptId, "部门Id不能为空");
        return userMapper.getUsersWithDeptId(deptId);
    }

    public List<User> getUsersWithRoleId(Long roleId) {
        Preconditions.checkNotNull(roleId, "角色Id不能为空");
        return userMapper.getUsersWithRoleId(roleId);
    }

}
