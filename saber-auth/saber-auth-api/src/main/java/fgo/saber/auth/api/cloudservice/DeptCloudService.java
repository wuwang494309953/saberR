package fgo.saber.auth.api.cloudservice;

import fgo.saber.auth.api.dto.DeptDto;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zq
 * @Date 2018/9/11
 */
@FeignClient("${feign.name}")
public interface DeptCloudService {

    /**
     * 根据部门id获取部门
     * @param deptId
     * @return
     */
    @GetMapping("/dept/{deptId}")
    JsonResult<DeptDto> findDeptWithId(@NotNull @PathVariable(name = "deptId") Long deptId);

    /**
     * 根据父id寻找子部门
     * @param parentId
     * @return
     */
    @GetMapping("/dept/parent/{parentId}")
    JsonResult<List<DeptDto>> findDeptsWithParentId(@PathVariable(name = "parentId") Long parentId);

    /**
     * 根据id删除部门
     * @param deptId
     * @return
     */
    @PostMapping("/dept/del")
    JsonResult<Integer> delDeptWithId(@NotNull @RequestParam(name = "deptId") Long deptId);

    /**
     * 保存部门
     * @param deptDto
     * @return
     */
    @PostMapping("/dept/save")
    JsonResult<Integer> saveDept(@RequestBody DeptDto deptDto);
}
