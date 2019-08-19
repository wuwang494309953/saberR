package fgo.saber.auth.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zq
 * @date 2019/8/2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppInfoDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long appId;

    /**
     * app名字
     */
    private String appName;

    /**
     * app秘钥
     */
    private String appSecret;

    /**
     * 描述
     */
    private String appDesc;

    /**
     * 0-无效，1-有效
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
