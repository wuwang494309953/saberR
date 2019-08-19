package fgo.saber.auth.provider.controller;

import com.github.pagehelper.PageInfo;
import fgo.saber.auth.api.dto.DeptDto;
import fgo.saber.auth.api.dto.DeptTreeDto;
import fgo.saber.auth.api.dto.PageDto;
import fgo.saber.auth.api.param.DeptParam;
import fgo.saber.auth.provider.service.impl.DeptServiceImpl;
import fgo.saber.base.json.JsonResult;
import fgo.saber.util.BeanUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zq
 * @Date 2018/9/11
 */
@Api(value = "DeptController", tags = "部门接口")
@RestController
@RequestMapping("/dept")
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
        return JsonResult.success("删除成功");
    }

    @PostMapping("/save")
    public JsonResult<Integer> saveDept(DeptParam deptParam) {
        deptService.save(deptParam);
        return JsonResult.success("保存成功");
    }

    @GetMapping("/foot")
    public JsonResult<List<DeptDto>> getDeptFootWithDeptName(String deptName) {
        return JsonResult.success(BeanUtil.toList(deptService.getDeptFootWithDeptName(deptName), DeptDto.class));
    }

    @GetMapping("/tree")
    public JsonResult<List<DeptTreeDto>> getDeptTree() {
        return JsonResult.success(deptService.getDeptOptions());
    }


}
