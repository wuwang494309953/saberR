package fgo.saber.authr.service.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fgo.saber.authr.service.common.AuthResultStatus;
import fgo.saber.authr.service.dao.RoleMapper;
import fgo.saber.authr.service.model.entity.Role;
import fgo.saber.authr.service.model.param.PageParam;
import fgo.saber.authr.service.model.param.RoleParam;
import fgo.saber.authr.service.model.vo.RoleVO;
import fgo.saber.common.abst.AbstBaseService;
import fgo.saber.util.BeanUtil;
import fgo.saber.util.SbPreconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @author zq
 * @date 2019/8/28
 */
@Service
public class RoleServiceImpl extends AbstBaseService<Role> {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Mapper<Role> getDao() {
        return roleMapper;
    }

    public PageInfo<RoleVO> findRoleList(RoleParam roleParam, PageParam pageParam) {
        String orderStr = pageParam.sortStr("r");
        if (StringUtils.isAnyBlank(pageParam.getSortKey(), pageParam.getSortValue())) {
            //默认根据时间排序
            orderStr = "create_time desc";
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), orderStr);

        return new PageInfo<>(roleMapper.getRoleNav(roleParam));
    }

    public void save(RoleParam roleParam) {
        if (roleParam.getRoleId() == null) {
            Role role = new Role();
            BeanUtil.overWrite(roleParam, role);
            role.setCreateTime(new Date());
            role.setUpdateTime(new Date());
            roleMapper.insertSelective(role);
        } else {
            Role role = roleMapper.selectByPrimaryKey(roleParam.getRoleId());
            SbPreconditions.checkNotNull(role, AuthResultStatus.ROLE_NOT_EXIST);
            BeanUtil.overWrite(roleParam, role);
            role.setUpdateTime(new Date());
            roleMapper.updateByPrimaryKeySelective(role);
        }

    }

    public List<Role> findRolesWithAppAndUserId(Long appId, Long userId) {
        return roleMapper.findRolesWithAppAndUserId(appId, userId);
    }
}
