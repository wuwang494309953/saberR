package fgo.saber.authr.service.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fgo.saber.authr.service.common.AuthResultStatus;
import fgo.saber.authr.service.dao.PermissionMapper;
import fgo.saber.authr.service.model.entity.Permission;
import fgo.saber.authr.service.model.param.PageParam;
import fgo.saber.authr.service.model.param.PermissionParam;
import fgo.saber.authr.service.model.vo.PermissionVO;
import fgo.saber.common.abst.AbstBaseService;
import fgo.saber.util.BeanUtil;
import fgo.saber.util.SbPreconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;

/**
 * @author zq
 * @date 2019/8/28
 */
@Service
public class PermissionServiceImpl extends AbstBaseService<Permission> {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Mapper<Permission> getDao() {
        return permissionMapper;
    }

    public PageInfo<PermissionVO> findPermissionList(PermissionParam permissionParam, PageParam pageParam) {
        String orderStr = pageParam.sortStr();
        if (StringUtils.isAnyBlank(pageParam.getSortKey(), pageParam.getSortValue())) {
            //默认根据时间排序
            orderStr = "create_time desc";
        }
        PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), orderStr);

        return new PageInfo<>(permissionMapper.getPermissionNav(permissionParam));
    }

    public void save(PermissionParam permissionParam) {
        if (permissionParam.getPermissionId() == null) {
            Permission permission = new Permission();
            BeanUtil.overWrite(permissionParam, permission);
            permission.setCreateTime(new Date());
            permission.setUpdateTime(new Date());
            permissionMapper.insertSelective(permission);
        } else {
            Permission permission = permissionMapper.selectByPrimaryKey(permissionParam.getPermissionId());
            SbPreconditions.checkNotNull(permission, AuthResultStatus.PERMISSION_NOT_EXIST);
            BeanUtil.overWrite(permissionParam, permission);
            permission.setUpdateTime(new Date());
            permissionMapper.updateByPrimaryKeySelective(permission);
        }

    }
}
