package fgo.saber.auth.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zq
 * @Date 2018/9/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long deptId;

    private String deptName;

    private String mail;

    private Date operateTime;

    private String username;

    private String remark;

    private Integer status;

    private String telephone;
}
