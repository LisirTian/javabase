package com.java2345online.common.vo;

import com.alibaba.fastjson.annotation.JSONType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
@JsonPropertyOrder({"orderID", "result", "data", "errors", "pageVo"})
@JSONType(orders= "orderID, result, data, errors, pageVo")
public class ApiResponseVo<T> {
    private String orderID;

    private String result = "SUCCESS"; // 返回结果 SUCCESS ERROR

    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ApiResponseErrorVo> errors;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ApiResponsePageVo pageInfo;
}
