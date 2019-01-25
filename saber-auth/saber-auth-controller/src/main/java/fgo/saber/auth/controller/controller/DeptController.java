package fgo.saber.auth.controller.controller;

import fgo.saber.auth.api.cloudservice.DeptCloudService;
import fgo.saber.auth.api.dto.DeptDto;
import fgo.saber.base.json.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public Map findDeptWithId(@PathVariable Long deptId) {
        return deptCloudService.findDeptWithId(deptId).toMap();
    }

    @GetMapping(path = {"/parent/{parentId}", "/parent"})
    public JsonResult findDeptsWithParentId(@PathVariable(required = false) Long parentId) {
        parentId = parentId == null ? 0 : parentId;
        return deptCloudService.findDeptsWithParentId(parentId);
    }

    @PostMapping("/del")
    public JsonResult delDeptWithId(Long deptId) {
        return deptCloudService.delDeptWithId(deptId);
    }

    @PostMapping("/save")
    public JsonResult saveDept(DeptDto deptDto) {
        return deptCloudService.saveDept(deptDto);
    }
}
