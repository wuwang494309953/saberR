package fgo.saber.auth.provider.model.entity;

import fgo.saber.auth.provider.mybatis.MyId;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Dept {

    @MyId
    private Long deptId;

    private String name;

    private String operateIp;

    private Date operateTime;

    private String operator;

    private Long parentId;

    private String remark;

    private Integer seq;

}