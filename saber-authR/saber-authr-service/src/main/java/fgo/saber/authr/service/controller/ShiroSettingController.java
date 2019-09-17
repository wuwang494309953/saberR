package fgo.saber.authr.service.controller;

import com.github.pagehelper.PageInfo;
import fgo.saber.authr.service.model.param.PageParam;
import fgo.saber.authr.service.model.param.ShiroSettingParam;
import fgo.saber.authr.service.model.vo.AppShiroSettingVO;
import fgo.saber.authr.service.model.vo.PageVO;
import fgo.saber.authr.service.service.ShiroSettingServiceImpl;
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
 * @date 2019/8/27
 */
@RestController
@RequestMapping("/shiro/setting")
public class ShiroSettingController {

    @Autowired
    private ShiroSettingServiceImpl shiroSettingService;

    @GetMapping("/list")
    public JsonResult list(ShiroSettingParam settingParam, PageParam pageParam) {
        PageInfo<AppShiroSettingVO> shiroSettingList = shiroSettingService.findShiroSettingList(settingParam, pageParam);
        PageVO<AppShiroSettingVO> pageDto = new PageVO<>(shiroSettingList.getTotal(), shiroSettingList.getList());
        return JsonResult.success(pageDto);
    }

    @PostMapping("/save")
    public JsonResult save(ShiroSettingParam settingParam) {
        BeanValidator.check(settingParam);
        shiroSettingService.save(settingParam);
        return JsonResult.success("保存Shiro配置成功");
    }

    @PostMapping("/del/{settingId}")
    public JsonResult del(@PathVariable Long settingId) {
        shiroSettingService.deleteByPrimaryKey(settingId);
        return JsonResult.success("删除Shiro配置成功");
    }

}
