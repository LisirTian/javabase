package com.java2345online.common.utils;

import org.springframework.util.StringUtils;

/**
 * <功能介绍>处理时间格式
 *
 * @author LISIR
 * @date 2020/5/4
 */
public class DateUtils {
    /**
     *
     *
     * @return
     */
    public boolean formatDate(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            return true;
        }

        return false;
    }
}
