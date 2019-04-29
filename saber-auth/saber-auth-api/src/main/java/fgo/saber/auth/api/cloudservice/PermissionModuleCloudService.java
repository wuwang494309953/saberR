package fgo.saber.auth.api.cloudservice;

import fgo.saber.auth.api.dto.PermissionDto;
import fgo.saber.auth.api.dto.PermissionModuleTreeDto;
import fgo.saber.auth.api.param.PermissionModuleParam;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zq
 * @date 2019/1/28
 */
@FeignClient(value = "${feign.name}", path = "/permission_module")
public interface PermissionModuleCloudService {

    /**
     * 根据用户id获取权限点
     * @param permissionModuleParam
     * @return
     */
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    JsonResult<List<PermissionDto>> save(PermissionModuleParam permissionModuleParam);

    /**
     * 根据id删除权限模块
     * @param permissionModuleId
     * @return
     */
    @PostMapping("/del")
    JsonResult<Integer> delPermissionModuleWithId(@RequestParam(name = "permissionModuleId") Long permissionModuleId);

    /**
     * 获取权限模块树
     * @return
     */
    @GetMapping("/tree")
    JsonResult<List<PermissionModuleTreeDto>> getPermissionModuleTree();

}
