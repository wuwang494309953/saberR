package fgo.saber.auth.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

/**
 * @author zq
 * @date 2019/4/26
 */
@Data
public class DeptTreeDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deptId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    private String name;

    private Integer seq;

    private List<DeptTreeDto> child;

}
