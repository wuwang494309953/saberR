package fgo.saber.authr.service.controller;

import com.github.pagehelper.PageInfo;
import fgo.saber.authr.service.common.AuthResultStatus;
import fgo.saber.authr.service.model.entity.User;
import fgo.saber.authr.service.model.param.PageParam;
import fgo.saber.authr.service.model.param.UserParam;
import fgo.saber.authr.service.model.vo.PageVO;
import fgo.saber.authr.service.service.UserServiceImpl;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/list")
    public JsonResult list(UserParam userParam, PageParam pageParam) {
        PageInfo<User> userList = userService.findUserList(userParam, pageParam);
        PageVO<User> pageDto = new PageVO<>(userList.getTotal(), userList.getList());
        return JsonResult.success(pageDto);
    }

    @PostMapping("/save")
    public JsonResult save(UserParam userParam) {
        BeanValidator.check(userParam);
        userService.save(userParam);
        return JsonResult.success("保存用户成功");
    }

    @PostMapping("/del/{userId}")
    public JsonResult del(@PathVariable Long userId) {
        User user = userService.selectByPrimaryKey(userId);
        if (user == null) {
            return AuthResultStatus.USER_NOT_EXIST;
        }
        user.setStatus(1);
        userService.updateByPrimaryKeySelective(user);
        return JsonResult.success("删除用户成功");
    }

}
