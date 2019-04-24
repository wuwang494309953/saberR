package fgo.saber.auth.provider.controller;

import com.github.pagehelper.PageInfo;
import fgo.saber.auth.api.dto.DeptDto;
import fgo.saber.auth.api.dto.PageDto;
import fgo.saber.auth.api.param.DeptParam;
import fgo.saber.auth.provider.model.entity.Dept;
import fgo.saber.auth.provider.service.impl.DeptServiceImpl;
import fgo.saber.base.json.JsonResult;
import fgo.saber.util.BeanUtil;
import fgo.saber.util.BeanValidator;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author zq
 * @Date 2018/9/11
 */
@Api(value = "DeptController", description = "部门控制器")
@RestController
@RequestMapping("dept")
@Validated
public class DeptController {

    @Autowired
    private DeptServiceImpl deptService;

    @GetMapping("/detail/{deptId}")
    public JsonResult<DeptDto> findDeptWithId(@PathVariable(name = "deptId") Long deptId) {
        DeptDto deptDto = BeanUtil.to(deptService.selectByPrimaryKey(deptId), DeptDto.class);
        return JsonResult.success(deptDto);
    }

    @GetMapping("/list")
    public JsonResult<PageDto> findDeptList(DeptParam deptParam) {
        PageInfo<DeptDto> deptPageInfo = deptService.findDeptList(deptParam);
        PageDto<DeptDto> pageDto = new PageDto<>(deptPageInfo.getTotal(), deptPageInfo.getList());
        return JsonResult.success(pageDto);
    }

    @GetMapping(path = {"/parent/{parentId}", "/parent"})
    public JsonResult<List<DeptDto>> findDeptsWithParentId(@PathVariable(name = "parentId", required = false) Long parentId) {
        parentId = parentId == null ? 0 : parentId;
        List<DeptDto> deptDtos = BeanUtil.toList(deptService.getDeptsWithParentId(parentId), DeptDto.class);
        return JsonResult.success(deptDtos);
    }

    @PostMapping("/del")
    public JsonResult<Integer> delDeptWithId(@NotNull(message = "deptId不能为空") Long deptId) {
        deptService.deleteByPrimaryKey(deptId);
        return JsonResult.success();
    }

    @PostMapping("/save")
    public JsonResult<Integer> saveDept(DeptParam deptParam) {
        BeanValidator.check(deptParam);
        Dept dept = BeanUtil.to(deptParam, Dept.class);
        dept.setOperateTime(new Date());
        if (dept.getDeptId() == null) {
            return JsonResult.success(deptService.insertSelective(dept));
        }
        return JsonResult.success(deptService.updateByPrimaryKeySelective(dept));
    }

    @GetMapping("/foot")
    public JsonResult<List<DeptDto>> getDeptFootWithDeptName(String deptName) {
        return JsonResult.success(BeanUtil.toList(deptService.getDeptFootWithDeptName(deptName), DeptDto.class));
    }


}
