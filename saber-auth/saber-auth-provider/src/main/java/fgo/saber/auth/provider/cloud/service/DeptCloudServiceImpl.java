package fgo.saber.auth.provider.cloud.service;

import fgo.saber.auth.provider.service.impl.DeptService;
import fgo.saber.cloudservice.DeptCloudService;
import fgo.saber.dto.DeptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zq
 * @Date 2018/9/11
 */
@RestController
@RequestMapping("dept")
public class DeptCloudServiceImpl implements DeptCloudService {

    @Autowired
    private DeptService deptService;


    @Override
    @GetMapping("get_dept")
    public DeptDto findDeptWithId(Long deptId) {
//        return deptService.selectByPrimaryKey(deptId);
        return null;
    }
}
