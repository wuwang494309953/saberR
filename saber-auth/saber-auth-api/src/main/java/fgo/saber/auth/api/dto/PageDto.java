package fgo.saber.auth.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zq
 * @date 2018/9/18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageDto<T> {

    /**
     * 总数
     */
    private long total;

    private List<T> data;

}
