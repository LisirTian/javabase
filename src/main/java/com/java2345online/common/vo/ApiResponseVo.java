package com.java2345online.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <功能介绍>标准响应体
 *
 * @author LISIR
 * @date 2020/5/4
 */
@Getter
@Setter
@Accessors(chain = true)
public class ApiResponseVo<T> {
    private String result; // 返回结果 SUCCESS ERROR

    private String orderID;

    private T data;

    private List<ApiResponseErrorVo> errors;
}
