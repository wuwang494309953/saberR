package fgo.saber.authr.service.controller;

import com.github.pagehelper.PageInfo;
import fgo.saber.authr.service.common.AuthResultStatus;
import fgo.saber.authr.service.model.entity.Permission;
import fgo.saber.authr.service.model.param.PageParam;
import fgo.saber.authr.service.model.param.PermissionParam;
import fgo.saber.authr.service.model.vo.PageVO;
import fgo.saber.authr.service.model.vo.PermissionVO;
import fgo.saber.authr.service.service.PermissionServiceImpl;
import fgo.saber.base.json.JsonResult;
import fgo.saber.util.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zq
 * @date 2019/8/28
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionServiceImpl permissionService;

    @GetMapping("/list")
    public JsonResult list(PermissionParam permissionParam, PageParam pageParam) {
        PageInfo<PermissionVO> permissionList = permissionService.findPermissionList(permissionParam, pageParam);
        PageVO<PermissionVO> pageDto = new PageVO<>(permissionList.getTotal(), permissionList.getList());
        return JsonResult.success(pageDto);
    }

    @PostMapping("/save")
    public JsonResult save(PermissionParam permissionParam) {
        BeanValidator.check(permissionParam);
        permissionService.save(permissionParam);
        return JsonResult.success("保存Shiro配置成功");
    }

    @PostMapping("/del/{permissionId}")
    public JsonResult del(@PathVariable Long permissionId) {
        Permission permission = permissionService.selectByPrimaryKey(permissionId);
        if (permission == null) {
            return AuthResultStatus.PERMISSION_NOT_EXIST;
        }
        permission.setStatus(0);
        permissionService.updateByPrimaryKeySelective(permission);
        return JsonResult.success("删除权限点成功");
    }

}
