package fgo.saber.authr.service.model.vo;

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
public class PageVO<T> {

    /**
     * 总数
     */
    private Long total;

    private List<T> data;

}
