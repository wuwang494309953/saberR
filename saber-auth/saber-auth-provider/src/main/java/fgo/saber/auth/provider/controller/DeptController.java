package fgo.saber.auth.provider.controller;

import fgo.saber.auth.api.dto.DeptDto;
import fgo.saber.auth.provider.model.entity.Dept;
import fgo.saber.auth.provider.service.impl.DeptServiceImpl;
import fgo.saber.base.json.JsonResult;
import fgo.saber.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zq
 * @Date 2018/9/11
 */
@RestController
@RequestMapping("dept")
@Validated
public class DeptController {

    @Autowired
    private DeptServiceImpl deptService;

    @GetMapping("/get/{deptId}")
    public JsonResult<DeptDto> findDeptWithId(@PathVariable(name = "deptId") Long deptId) {
        DeptDto deptDto = BeanUtil.to(deptService.selectByPrimaryKey(deptId), DeptDto.class);
        return JsonResult.success(deptDto);
    }

    @GetMapping(path = {"/parent/{parentId}", "/parent"})
    public JsonResult<List<DeptDto>> findDeptsWithParentId(@PathVariable(name = "parentId", required = false) Long parentId) {
        parentId = parentId == null ? 0 : parentId;
        return JsonResult.success(BeanUtil.toList(deptService.getDeptsWithParentId(parentId), DeptDto.class));
    }

    @PostMapping("/del")
    public JsonResult<Integer> delDeptWithId(@NotNull(message = "deptId不能为空") Long deptId) {
        deptService.deleteByPrimaryKey(deptId);
        return JsonResult.success();
    }

    @PostMapping("/save")
    public JsonResult<Integer> saveDept(@RequestBody DeptDto deptDto) {
        Dept dept = BeanUtil.to(deptDto, Dept.class);
        if (dept.getDeptId() == null) {
            return JsonResult.success(deptService.insertSelective(dept));
        }
        return JsonResult.success(deptService.updateByPrimaryKeySelective(dept));
    }

}
