package fgo.saber.cloudservice;

import fgo.saber.dto.DeptDto;

/**
 * @author zq
 * @Date 2018/9/11
 */
public interface DeptCloudService {

    /**
     * 根据部门id获取部门
     * @param deptId
     * @return
     */
    DeptDto findDeptWithId(Long deptId);

}
