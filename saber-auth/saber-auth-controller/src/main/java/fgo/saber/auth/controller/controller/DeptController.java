package fgo.saber.auth.controller.controller;

import fgo.saber.auth.api.cloudservice.DeptCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("get")
    public Map findDeptWithId(Long deptId) {
        return deptCloudService.findDeptWithId(deptId).toMap();
    }

    @GetMapping("get_depts")
    public Map findDeptsWithParentId(Long parentId) {
        return deptCloudService.findDeptsWithParentId(parentId).toMap();
    }

    @PostMapping("/dept/del")
    public Map delDeptWithId(Long deptId) {
        return deptCloudService.delDeptWithId(deptId).toMap();
    }
}
