package com.java2345online.common.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <功能介绍>
 *
 * @author LISIR
 * @date 2020/6/21
 */
@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class ApiResponsePageVo {
    public ApiResponsePageVo(Integer totalRows, Integer pageSize) {
        this.totalRows = totalRows;
        this.pageSize = pageSize;
        this.totalPages = (totalRows-1)/pageSize +1;
    }

    private Integer currentPage  = 1; // 当前页码

    private Integer pageSize = 30; // 每页显示条数

    private Integer totalPages = 1; // 总页数

    private Integer totalRows = 0; // 数据总数
}
