package fgo.saber.auth.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import fgo.saber.auth.api.dto.UserDto;
import fgo.saber.auth.api.param.PageParam;
import fgo.saber.auth.api.param.UserParam;
import fgo.saber.auth.provider.dao.UserMapper;
import fgo.saber.auth.provider.model.entity.User;
import fgo.saber.common.abst.AbstBaseService;
import fgo.saber.util.BeanUtil;
import fgo.saber.util.BeanValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
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

    public PageInfo<UserDto> findUserList(UserParam userParam, PageParam pageParam) {
        String orderStr = pageParam.sortStr("su");
        if (StringUtils.isAnyBlank(pageParam.getSortKey(), pageParam.getSortValue())) {
            //默认根据时间排序
            orderStr = "su.operate_time desc";
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), orderStr);
        return new PageInfo<>(userMapper.findUserList(userParam));
    }

    public List<User> findUsersWithDeptId(Long deptId) {
        Preconditions.checkNotNull(deptId, "部门Id不能为空");
        return userMapper.getUsersWithDeptId(deptId);
    }

    public List<User> findUsersWithRoleId(Long roleId) {
        Preconditions.checkNotNull(roleId, "角色Id不能为空");
        return userMapper.getUsersWithRoleId(roleId);
    }

    public void save(UserParam userParam) {
        BeanValidator.check(userParam);

        User user = User.builder()
                .username(userParam.getUsername())
                .deptId(userParam.getDeptId())
                .telephone(userParam.getTelephone())
                .mail(userParam.getMail())
                .status(userParam.getStatus())
                .remark(userParam.getRemark())
                //todo:获取请求ip和操作者
                .operateIp("127.0.0.1")
                .operator("admin")
                .operateTime(new Date())
                .build();

        userMapper.insertSelective(user);
    }

    public void update(UserParam userParam) {
        BeanValidator.check(userParam);

        User user = User.builder()
                .username(userParam.getUsername())
                .deptId(userParam.getDeptId())
                .telephone(userParam.getTelephone())
                .mail(userParam.getMail())
                .status(userParam.getStatus())
                .remark(userParam.getRemark())
                //todo:获取请求ip和操作者
                .operateIp("127.0.0.1")
                .operator("admin")
                .operateTime(new Date())
                .build();

        User oldUser = userMapper.selectByPrimaryKey(userParam.getUserId());
        Preconditions.checkNotNull(oldUser, "待更新用户不存在");

        BeanUtil.overWrite(oldUser, user);
        userMapper.insertSelective(oldUser);
    }

    public User findUserWithPhone(String username) {
        User user = User.builder().telephone(username).build();
        return userMapper.selectOne(user);
    }
}
