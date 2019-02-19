package fgo.saber.auth.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zq
 * @Date 2018/9/11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deptId;

    private String name;

    private String operateIp;

    private Date operateTime;

    private String operator;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    private String remark;

    private Integer seq;
}
