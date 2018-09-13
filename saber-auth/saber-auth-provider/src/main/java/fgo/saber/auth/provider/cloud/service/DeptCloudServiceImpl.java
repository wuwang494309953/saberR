package fgo.saber.auth.provider.cloud.service;

import fgo.saber.auth.api.cloudservice.DeptCloudService;
import fgo.saber.auth.api.dto.DeptDto;
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
public class DeptCloudServiceImpl implements DeptCloudService {

    @Autowired
    private DeptServiceImpl deptService;

    @Override
    @GetMapping("get")
    public JsonResult<DeptDto> findDeptWithId(@NotNull Long deptId) {
        DeptDto deptDto = BeanUtil.copy(deptService.selectByPrimaryKey(deptId), DeptDto.class);
        return JsonResult.success(deptDto);
    }

    @Override
    @GetMapping("get_depts")
    public JsonResult<List<DeptDto>> findDeptsWithParentId(@RequestParam(name = "parentId", defaultValue = "0") Long parentId) {
        return JsonResult.success(BeanUtil.copyList(deptService.getDeptsWithParentId(parentId), DeptDto.class));
    }

    @Override
    @PostMapping("/dept/del")
    public JsonResult<Integer> delDeptWithId(@NotNull Long deptId) {
        return JsonResult.success(deptService.deleteByPrimaryKey(deptId));
    }

}
