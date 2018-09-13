package fgo.saber.auth.api.cloudservice;

import fgo.saber.auth.api.dto.DeptDto;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zq
 * @Date 2018/9/11
 */
@FeignClient("saber-auth")
public interface DeptCloudService {

    /**
     * 根据部门id获取部门
     * @param deptId
     * @return
     */
    @GetMapping("/dept/get")
    JsonResult<DeptDto> findDeptWithId(@NotNull @RequestParam(name = "deptId") Long deptId);

    /**
     * 根据父id寻找子部门
     * @param parentId
     * @return
     */
    @GetMapping("/dept/get_depts")
    JsonResult<List<DeptDto>> findDeptsWithParentId(@RequestParam(name = "parentId") Long parentId);

    /**
     * 根据id删除部门
     * @param deptId
     * @return
     */
    @PostMapping("/dept/del")
    JsonResult<Integer> delDeptWithId(@NotNull @RequestParam(name = "deptId") Long deptId);
}
