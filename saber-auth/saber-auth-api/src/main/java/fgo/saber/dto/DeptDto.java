package fgo.saber.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author zq
 * @Date 2018/9/11
 */
@Data
@Builder
public class DeptDto {

    private Long deptId;

    private String name;

    private String operateIp;

    private Date operateTime;

    private String operator;

    private Long parentId;

    private String remark;

    private Integer seq;
}
