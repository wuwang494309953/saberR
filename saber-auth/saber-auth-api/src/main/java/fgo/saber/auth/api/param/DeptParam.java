package fgo.saber.auth.api.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zq
 * @date 2019/2/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptParam extends PageParam {

    private Long deptId;

    @NotBlank(message = "部门名字name不能为空")
    private String name;

    @NotNull(message = "父节点不能为空")
    private Long parentId;

    private String remark;

    private Integer seq;
}
