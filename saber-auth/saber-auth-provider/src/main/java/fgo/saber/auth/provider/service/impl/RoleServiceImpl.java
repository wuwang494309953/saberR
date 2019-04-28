package fgo.saber.auth.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import fgo.saber.auth.api.param.PageParam;
import fgo.saber.auth.api.param.RoleParam;
import fgo.saber.auth.provider.dao.RoleMapper;
import fgo.saber.auth.provider.model.entity.Role;
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
 * @author zq
 * @date 2018/10/23
 */
@Service
public class RoleServiceImpl extends AbstBaseService<Role>  {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Mapper<Role> getDao() {
        return roleMapper;
    }

    public PageInfo<Role> findRoleList(RoleParam roleParam, PageParam pageParam) {
        String orderStr = pageParam.sortStr();
        if (StringUtils.isAnyBlank(pageParam.getSortKey(), pageParam.getSortValue())) {
            //默认根据时间排序
            orderStr = "operate_time desc";
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), orderStr);
        return new PageInfo<>(roleMapper.findRoleList(roleParam));
    }

    public void save(RoleParam roleParam) {
        BeanValidator.check(roleParam);

        if (roleParam.getRoleId() == null) {
            Role role = Role.builder()
                    .name(roleParam.getName())
                    .type(roleParam.getType())
                    .status(roleParam.getStatus())
                    .remark(roleParam.getRemark())
                    //todo:获取请求ip和操作者
                    .operateIp("127.0.0.1")
                    .operator("admin")
                    .operateTime(new Date())
                    .build();

            roleMapper.insertSelective(role);
        } else {
            Role oldRole = roleMapper.selectByPrimaryKey(roleParam.getRoleId());
            Preconditions.checkNotNull(oldRole, "待更新角色不存在");

            oldRole.setOperateTime(new Date());
            oldRole.setOperateIp("127.0.0.1");
            oldRole.setOperator("admin");
            BeanUtil.overWrite(oldRole, roleParam);
            roleMapper.updateByPrimaryKeySelective(oldRole);
        }
    }

    public List<Role> findRolesWithUserId(Long userId) {
        return roleMapper.findRoleListWithUserId(userId);
    }
}
