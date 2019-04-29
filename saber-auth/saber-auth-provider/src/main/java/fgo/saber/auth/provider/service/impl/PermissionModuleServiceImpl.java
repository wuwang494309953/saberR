package fgo.saber.auth.provider.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import fgo.saber.auth.api.dto.DeptTreeDto;
import fgo.saber.auth.api.dto.PermissionModuleTreeDto;
import fgo.saber.auth.api.param.PermissionModuleParam;
import fgo.saber.auth.provider.common.SaberAuthConstant;
import fgo.saber.auth.provider.dao.PermissionModuleMapper;
import fgo.saber.auth.provider.model.entity.PermissionModule;
import fgo.saber.common.abst.AbstBaseService;
import fgo.saber.util.BeanUtil;
import fgo.saber.util.BeanValidator;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author zq
 * @date 2018/10/24
 */
@Service
public class PermissionModuleServiceImpl extends AbstBaseService<PermissionModule> {

    @Autowired
    private PermissionModuleMapper permissionModuleMapper;

    @Override
    public Mapper<PermissionModule> getDao() {
        return permissionModuleMapper;
    }

    public List<PermissionModule> findPermissionModuleWithRoleId(Long roleId) {
        return permissionModuleMapper.findPermissionModuleWithRoleId(roleId);
    }

    public List<PermissionModule> findPermissionModuleWithParentId(Long parentId) {
        return permissionModuleMapper.findPermissionModuleWithParentId(parentId);
    }

    public void save(PermissionModuleParam permissionModuleParam) {
        BeanValidator.check(permissionModuleParam);
        if (permissionModuleParam.getPermissionModuleId() == null) {
            PermissionModule permissionModule = PermissionModule.builder()
                    .permissionModuleId(permissionModuleParam.getPermissionModuleId())
                    .name(permissionModuleParam.getName())
                    .status(permissionModuleParam.getStatus())
                    .operateIp("127.0.0.1")
                    .operateTime(new Date())
                    .operator("admin")
                    .parentId(permissionModuleParam.getParentId())
                    .remark(permissionModuleParam.getRemark())
                    .seq(permissionModuleParam.getSeq())
                    .build();
            permissionModuleMapper.insertSelective(permissionModule);
        } else {
            PermissionModule permissionModule = permissionModuleMapper.selectByPrimaryKey(permissionModuleParam.getPermissionModuleId());
            Preconditions.checkNotNull(permissionModule, "待更新模块不存在");
            BeanUtil.overWrite(permissionModule, permissionModuleParam);
            permissionModuleMapper.updateByPrimaryKeySelective(permissionModule);
        }
    }

    public List<PermissionModuleTreeDto> getpermissionModuleTree() {
        List<PermissionModule> permissionModules = permissionModuleMapper.selectAll();
        List<PermissionModuleTreeDto> permissionModuleTreeDtos = BeanUtil.toList(permissionModules, PermissionModuleTreeDto.class);
        Multimap<Long, PermissionModuleTreeDto> permissionModuleTreeDtoMultimap = ArrayListMultimap.create();
        List<PermissionModuleTreeDto> rootList = Lists.newArrayList();
        permissionModuleTreeDtos.forEach(permissionModuleTreeDto -> {
            permissionModuleTreeDtoMultimap.put(permissionModuleTreeDto.getParentId(), permissionModuleTreeDto);
            if (permissionModuleTreeDto.getParentId().equals(SaberAuthConstant.root)) {
                rootList.add(permissionModuleTreeDto);
            }
        });
        permissionModuleTreeDtos.sort(Comparator.comparingInt(PermissionModuleTreeDto::getSeq));
        transformDeptTree(rootList, permissionModuleTreeDtoMultimap);
        return rootList;
    }

    private void transformDeptTree(List<PermissionModuleTreeDto> permissionModuleTreeDtos, Multimap<Long, PermissionModuleTreeDto> permissionModuleTreeDtoMultimap) {
        for (PermissionModuleTreeDto permissionModuleTreeDto : permissionModuleTreeDtos) {
            List<PermissionModuleTreeDto> parentDepts = (List<PermissionModuleTreeDto>) permissionModuleTreeDtoMultimap.get(permissionModuleTreeDto.getPermissionModuleId());
            if (CollectionUtils.isNotEmpty(parentDepts)) {
                permissionModuleTreeDto.setChild(parentDepts);
            }
            transformDeptTree(parentDepts, permissionModuleTreeDtoMultimap);
        }
    }
}
