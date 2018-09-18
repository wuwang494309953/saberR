package fgo.saber.auth.api.dto;

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
public class PageDto<E> {

    /**
     * 页码，从1开始
     */
    private int pageNum;

    /**
     * 页面大小
     */
    private int pageSize;

    /**
     * 总数
     */
    private long total;

    private String sortKey;

    private String sortValue;

    private List<E> data;

}
