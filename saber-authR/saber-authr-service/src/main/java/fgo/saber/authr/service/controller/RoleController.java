package fgo.saber.authr.service.controller;

import com.github.pagehelper.PageInfo;
import fgo.saber.authr.service.model.param.PageParam;
import fgo.saber.authr.service.model.param.RoleParam;
import fgo.saber.authr.service.model.vo.PageVO;
import fgo.saber.authr.service.model.vo.RoleVO;
import fgo.saber.authr.service.service.RoleServiceImpl;
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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/list")
    public JsonResult list(RoleParam roleParam, PageParam pageParam) {
        PageInfo<RoleVO> roleList = roleService.findRoleList(roleParam, pageParam);
        PageVO<RoleVO> pageDto = new PageVO<>(roleList.getTotal(), roleList.getList());
        return JsonResult.success(pageDto);
    }

    @PostMapping("/save")
    public JsonResult save(RoleParam roleParam) {
        BeanValidator.check(roleParam);
        roleService.save(roleParam);
        return JsonResult.success("保存角色成功");
    }

    @PostMapping("/del/{roleId}")
    public JsonResult del(@PathVariable Long roleId) {
        roleService.deleteByPrimaryKey(roleId);
        return JsonResult.success("删除角色成功");
    }

}
