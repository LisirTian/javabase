package com.java2345online.common.utils;

import com.java2345online.common.constant.CommonConst;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <功能介绍>处理时间格式
 *
 * @author LISIR
 * @date 2020/5/4
 */
public class DateUtil {
    /**
     * 判断string是否是时间类型
     *
     * @param date 传入的字符串
     * @return 是否时间类型：是true 否false
     */
    public static boolean isDate(String date) {
        if (StringUtils.isEmpty(date)) {
            return true;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(CommonConst.DATE_FORMAT_DEFAULT);
        try {
            dateFormat.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 是否时间内类型
     *
     * @param date 字符串
     * @param pattern    时间格式
     * @return 是否是时间字符串
     */
    public static boolean isDate(String date, String pattern) {
        if (StringUtils.isEmpty(date)) {
            return true;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            dateFormat.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 将字符串转换为时间
     *
     * @param date 字符串
     * @return 时间
     * @throws ParseException
     */
    public static Date parseDate(String date) throws ParseException {
        if (StringUtils.isEmpty(date)) {
            return new Date();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(CommonConst.DATE_FORMAT_DEFAULT);

        return dateFormat.parse(date);
    }

    /**
     * 将字符串转换为时间
     *
     * @param date    字符串
     * @param pattern 时间格式
     * @return 时间
     * @throws ParseException
     */
    public static Date parseDate(String date, String pattern) throws ParseException {
        if (StringUtils.isEmpty(date)) {
            return new Date();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

        return dateFormat.parse(date);
    }

    /**
     * 获取时间格式化后的字符串
     *
     * @param date 时间
     * @return "yyyy-MM-dd HH:mm:ss"类型时间
     */
    public static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(CommonConst.DATE_FORMAT_DEFAULT);
        return dateFormat.format(date);
    }

    /**
     * 获取时间格式化后的字符串
     *
     * @param date    时间
     * @param pattern 时间格式
     * @return 返回时间字符串
     */
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
}
