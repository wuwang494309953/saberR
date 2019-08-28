package fgo.saber.authr.service.controller;

import com.github.pagehelper.PageInfo;
import fgo.saber.authr.service.model.entity.Resource;
import fgo.saber.authr.service.model.param.PageParam;
import fgo.saber.authr.service.model.param.ResourceParam;
import fgo.saber.authr.service.model.vo.PageVO;
import fgo.saber.authr.service.service.ResourceServiceImpl;
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
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceServiceImpl resourceService;

    @GetMapping("/list")
    public JsonResult list(ResourceParam resourceParam, PageParam pageParam) {
        PageInfo<Resource> resourceList = resourceService.findResourceList(resourceParam, pageParam);
        PageVO<Resource> pageDto = new PageVO<>(resourceList.getTotal(), resourceList.getList());
        return JsonResult.success(pageDto);
    }

    @PostMapping("/save")
    public JsonResult save(ResourceParam resourceParam) {
        BeanValidator.check(resourceParam);
        resourceService.save(resourceParam);
        return JsonResult.success("保存资源成功");
    }

    @PostMapping("/del/{resourceId}")
    public JsonResult del(@PathVariable Long resourceId) {
        resourceService.deleteByPrimaryKey(resourceId);
        return JsonResult.success("删除权限点成功");
    }
}
