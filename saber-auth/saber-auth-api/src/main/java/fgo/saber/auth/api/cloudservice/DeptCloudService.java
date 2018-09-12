package fgo.saber.auth.api.cloudservice;

import fgo.saber.auth.api.dto.DeptDto;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/dept/get_dept")
    JsonResult<DeptDto> findDeptWithId(@NotNull @RequestParam(name = "deptId") Long deptId);

    @GetMapping("/dept/get_depts")
    JsonResult<List<DeptDto>> findDeptsWithParentId(@NotNull @RequestParam(name = "parentId") Long parentId);

    @GetMapping("/dept/del")
    JsonResult<Integer> delDeptWithId(@NotNull @RequestParam(name = "deptId") Long deptId);
}
