package fgo.saber.auth.api.cloudservice;

import fgo.saber.auth.api.dto.DeptDto;
import fgo.saber.auth.api.dto.DeptTreeDto;
import fgo.saber.auth.api.dto.PageDto;
import fgo.saber.auth.api.param.DeptParam;
import fgo.saber.base.json.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zq
 * @Date 2018/9/11
 */
@FeignClient(value = "saber-auth-provider", path = "/dept")
public interface DeptCloudService {

    /**
     * 根据部门id获取部门
     * @param deptId
     * @return
     */
    @GetMapping("/{deptId}")
    JsonResult<DeptDto> findDeptWithId(@NotNull @PathVariable(name = "deptId") Long deptId);

    /**
     *根据部门列表
     * @param deptParam
     * @return
     */
    @GetMapping("/list")
    JsonResult<PageDto> findDeptList(@SpringQueryMap DeptParam deptParam);

    /**
     * 根据父id寻找子部门
     * @param parentId
     * @return
     */
    @GetMapping("/parent/{parentId}")
    JsonResult<List<DeptDto>> findDeptsWithParentId(@PathVariable(name = "parentId") Long parentId);

    /**
     * 根据id删除部门
     * @param deptId
     * @return
     */
    @PostMapping("/del")
    JsonResult<Integer> delDeptWithId(@RequestParam(name = "deptId") Long deptId);

    /**
     * 保存部门
     * @param deptParam
     * @return
     */
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    JsonResult<Integer> saveDept(DeptParam deptParam);

    /**
     * 根据部门名搜索没有子节点的部门
     * @param deptName
     * @return
     */
    @GetMapping("/foot")
    JsonResult<List<DeptDto>> getDeptFootWithDeptName(@RequestParam(name = "deptName") String deptName);

    /**
     * 获取部门树
     * @return
     */
    @GetMapping("/tree")
    JsonResult<List<DeptTreeDto>> getDeptTree();
}
