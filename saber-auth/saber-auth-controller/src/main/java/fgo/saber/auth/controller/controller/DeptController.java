package fgo.saber.auth.controller.controller;

import fgo.saber.auth.api.cloudservice.DeptCloudService;
import fgo.saber.auth.api.dto.DeptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
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

    @GetMapping("get_dept")
    public Map findDeptWithId(@NotNull Long deptId) {
        return deptCloudService.findDeptWithId(deptId).toMap();
    }

}
