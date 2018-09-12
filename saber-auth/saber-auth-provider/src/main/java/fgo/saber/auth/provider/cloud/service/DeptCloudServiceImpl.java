package fgo.saber.auth.provider.cloud.service;

import fgo.saber.auth.api.cloudservice.DeptCloudService;
import fgo.saber.auth.api.dto.DeptDto;
import fgo.saber.base.json.JsonResult;
import fgo.saber.auth.provider.service.impl.DeptService;
import fgo.saber.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author zq
 * @Date 2018/9/11
 */
@RestController
@RequestMapping("dept")
@Validated
public class DeptCloudServiceImpl implements DeptCloudService {

    @Autowired
    private DeptService deptService;

    @Override
    @GetMapping("get_dept")
    public JsonResult<DeptDto> findDeptWithId(@NotNull Long deptId) {
        DeptDto deptDto = BeanUtil.copy(deptService.selectByPrimaryKey(deptId), DeptDto.class);
        return JsonResult.success(deptDto);
    }

}
