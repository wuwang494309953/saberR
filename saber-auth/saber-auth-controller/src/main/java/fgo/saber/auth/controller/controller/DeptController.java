package fgo.saber.auth.controller.controller;

import fgo.saber.auth.api.cloudservice.DeptCloudService;
import fgo.saber.auth.api.dto.DeptTreeDto;
import fgo.saber.auth.api.param.DeptParam;
import fgo.saber.base.json.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zq
 * @Date 2018/9/12
 */
@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptCloudService deptCloudService;

    @GetMapping("/{deptId}")
    public JsonResult findDeptWithId(@PathVariable Long deptId) {
        return deptCloudService.findDeptWithId(deptId);
    }

    @GetMapping("/list")
    public JsonResult findDeptList(DeptParam deptParam) {
        return deptCloudService.findDeptList(deptParam);
    }

//    @RequiresRoles("admin")
    @GetMapping(path = {"/parent/{parentId}", "/parent"})
//    @JsonView(DeptDto.DeptTreeView.class)
    public JsonResult findDeptsWithParentId(@PathVariable(required = false) Long parentId) {
        parentId = parentId == null ? 0 : parentId;
        return deptCloudService.findDeptsWithParentId(parentId);
    }

    @PostMapping("/del")
    public JsonResult delDeptWithId(Long deptId) {
        return deptCloudService.delDeptWithId(deptId);
    }

    @PostMapping("/save")
    public JsonResult saveDept(DeptParam deptParam) {
        return deptCloudService.saveDept(deptParam);
    }

    @GetMapping("/foot")
    public JsonResult getDeptFootWithDeptName(String deptName) {
        return deptCloudService.getDeptFootWithDeptName(deptName);
    }

    @GetMapping("/tree")
    public JsonResult<List<DeptTreeDto>> getDeptTree() {
        return deptCloudService.getDeptTree();
    }
}
