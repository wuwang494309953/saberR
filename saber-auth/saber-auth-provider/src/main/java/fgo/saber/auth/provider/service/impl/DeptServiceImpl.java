package fgo.saber.auth.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import fgo.saber.auth.api.dto.DeptDto;
import fgo.saber.auth.api.dto.DeptTreeDto;
import fgo.saber.auth.api.param.DeptParam;
import fgo.saber.auth.provider.common.SaberAuthConstant;
import fgo.saber.auth.provider.dao.DeptMapper;
import fgo.saber.auth.provider.model.entity.Dept;
import fgo.saber.common.abst.AbstBaseService;
import fgo.saber.util.BeanUtil;
import fgo.saber.util.BeanValidator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zq
 * @Date 2018/9/11
 */
@Service
public class DeptServiceImpl extends AbstBaseService<Dept> {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Mapper<Dept> getDao() {
        return deptMapper;
    }

    public PageInfo<DeptDto> findDeptList(DeptParam deptParam) {
        String orderStr = deptParam.sortStr("sd");
        if (StringUtils.isAnyBlank(deptParam.getSortKey(), deptParam.getSortValue())) {
            //默认根据时间排序
            orderStr = "sd.operate_time desc";
        }
        PageHelper.startPage(deptParam.getPageNum(), deptParam.getPageSize(), orderStr);
//        Example example = Example.builder(Dept.class).build();
//        Optional.ofNullable(deptParam.getName()).ifPresent(deptName -> example.and().andLike("name", "%" + deptName + "%"));
        return new PageInfo<>(deptMapper.findDeptDtoList(deptParam));
    }

    public void save(DeptParam deptParam) {
        BeanValidator.check(deptParam);
        if (deptParam.getDeptId() == null) {
            Dept dept = Dept.builder()
                    .deptId(deptParam.getDeptId())
                    .name(deptParam.getName())
                    .operateIp("127.0.0.1")
                    .operateTime(new Date())
                    .operator("admin")
                    .parentId(deptParam.getParentId())
                    .remark(deptParam.getRemark())
                    .seq(deptParam.getSeq())
                    .build();
            deptMapper.insertSelective(dept);
        } else {
            Dept dept = deptMapper.selectByPrimaryKey(deptParam.getDeptId());
            Preconditions.checkNotNull(dept, "待更新部门不存在");
            BeanUtil.overWrite(dept, deptParam);
            deptMapper.updateByPrimaryKeySelective(dept);
        }
    }

    public List<DeptDto> getDeptsWithParentId(Long parentId) {
        return deptMapper.findDeptsWithParentId(parentId);
    }

    public List<Dept> getDeptFootWithDeptName(String deptName) {
        return deptMapper.getDeptFootWithDeptName(deptName);
    }

    public List<DeptTreeDto> getDeptOptions() {
        List<Dept> depts = deptMapper.selectAll();
        List<DeptTreeDto> deptDtos = BeanUtil.toList(depts, DeptTreeDto.class);

        Multimap<Long, DeptTreeDto> deptTreeDtoMultimap = ArrayListMultimap.create();
        List<DeptTreeDto> rootList = Lists.newArrayList();
        deptDtos.forEach(deptTreeDto -> {
            deptTreeDtoMultimap.put(deptTreeDto.getParentId(), deptTreeDto);
            if (deptTreeDto.getParentId().equals(SaberAuthConstant.root)) {
                rootList.add(deptTreeDto);
            }
        });
        deptDtos.sort(Comparator.comparingInt(DeptTreeDto::getSeq));
        transformDeptTree(rootList, deptTreeDtoMultimap);
        return rootList;
    }

    private void transformDeptTree(List<DeptTreeDto> deptTreeDtos, Multimap<Long, DeptTreeDto> deptTreeDtoMultimap) {
        for (DeptTreeDto deptTreeDto : deptTreeDtos) {
            List<DeptTreeDto> parentDepts = (List<DeptTreeDto>) deptTreeDtoMultimap.get(deptTreeDto.getDeptId());
            if (CollectionUtils.isNotEmpty(parentDepts)) {
                deptTreeDto.setChild(parentDepts);
            }
            transformDeptTree(parentDepts, deptTreeDtoMultimap);
        }
    }
}
