package com.java2345online.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <功能介绍>响应体错误信息
 *
 * @author LISIR
 * @date 2020/5/4
 */
@Getter
@Setter
@Accessors(chain = true)
public class ApiResponseErrorVo {
    private String code;

    private List<String> args; // 错误参数

    private String message; // 错误信息

    private String messageEn;

    private String detail; // 具体错误细节

    private String detailEn;
}
