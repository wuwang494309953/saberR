package fgo.saber.authr.service.controller;

import fgo.saber.authr.service.model.param.UserRoleParam;
import fgo.saber.authr.service.service.UserRoleServiceImpl;
import fgo.saber.base.json.JsonResult;
import fgo.saber.util.BeanValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zq
 * @date 2019/9/19
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @PostMapping("/save")
    public JsonResult save(UserRoleParam param) {
        BeanValidator.check(param);
        userRoleService.save(param);
        return JsonResult.success("保存用户角色关系成功");
    }

}
