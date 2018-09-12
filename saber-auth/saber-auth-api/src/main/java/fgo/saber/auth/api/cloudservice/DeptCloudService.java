package fgo.saber.auth.api.cloudservice;

import fgo.saber.auth.api.dto.DeptDto;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

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
    JsonResult<DeptDto> findDeptWithId(@NotNull @RequestParam(name = "deptId", defaultValue = "null") Long deptId);
}
