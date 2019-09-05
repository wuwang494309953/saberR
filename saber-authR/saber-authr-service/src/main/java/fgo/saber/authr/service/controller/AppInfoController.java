package fgo.saber.authr.service.controller;

import com.github.pagehelper.PageInfo;
import fgo.saber.authr.service.common.AuthResultStatus;
import fgo.saber.authr.service.model.entity.AppInfo;
import fgo.saber.authr.service.model.param.AppInfoParam;
import fgo.saber.authr.service.model.param.PageParam;
import fgo.saber.authr.service.model.vo.PageVO;
import fgo.saber.authr.service.service.AppInfoServiceImpl;
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
@RequestMapping("/app/info")
public class AppInfoController {

    @Autowired
    private AppInfoServiceImpl appInfoService;

    @GetMapping("/list")
    public JsonResult list(AppInfoParam appInfoParam, PageParam pageParam) {
        PageInfo<AppInfo> appInfoPageInfo = appInfoService.findAppInfoList(appInfoParam, pageParam);
        PageVO<AppInfo> pageDto = new PageVO<>(appInfoPageInfo.getTotal(), appInfoPageInfo.getList());
        return JsonResult.success(pageDto);
    }

    @PostMapping("/save")
    public JsonResult save(AppInfoParam appInfoParam) {
        BeanValidator.check(appInfoParam);
        appInfoService.save(appInfoParam);
        return JsonResult.success("保存应用成功");
    }

    @PostMapping("/del/{appInfoId}")
    public JsonResult del(@PathVariable Long appInfoId) {
        AppInfo appInfo = appInfoService.selectByPrimaryKey(appInfoId);
        if (appInfo == null) {
            return AuthResultStatus.APP_NOT_EXIST;
        }
        appInfo.setStatus(0);
        appInfoService.updateByPrimaryKeySelective(appInfo);
        return JsonResult.success("删除应用成功");
    }



}
