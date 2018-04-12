package com.pm.slxy.utils;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * 基于Joda Time的时间工具类（Thread-Safe） <br/>
 * @Author furg@senthink.com
 * @Date 2018-1-5 12:39
 */
public class JodaTimeUtils {

    /**
     * DEFAULT_DATE_TIME_PATTERN: 默认的时间格式为 "yyyy-MM-dd HH:mm:ss" -- 例如："2018-01-05 13:59:08"
     */
    private static final String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /**
     * DEFAULT_DATE_PATTERN: 默认的日期格式为 "yyyy-MM-dd" -- 例如："2018-01-05"
     */
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    private JodaTimeUtils() {}

    /**
     * 将当前时间转换成字符串时间格式 <br/>
     * @return
     * 返回默认格式的时间字符串："yyyy-MM-dd HH:mm:ss" -- 例如："2018-01-05 13:59:08"
     */
    public static String formatDateTimeNow() {
        return new DateTime().toString(DEFAULT_DATE_TIME_PATTERN);
    }

    /**
     * 将当前时间转换成字符串时间格式 <br/>
     * @param pattern 指定的时间格式
     * @return
     * 返回指定格式的时间字符串。如果pattern为null，则使用默认的时间格式："yyyy-MM-dd HH:mm:ss"
     */
    public static String formatDateTimeNow(String pattern) {
        if (pattern == null) {
            return formatDateTimeNow();
        }
        return new DateTime().toString(pattern);
    }

    /**
     * 将指定的时间转换成字符串时间格式 <br/>
     * @param date Java的时间对象 {@link Date}
     * @return
     * 返回默认格式的时间字符串："yyyy-MM-dd HH:mm:ss" -- 例如："2018-01-05 13:59:08"
     */
    public static String formatDateTime(Date date) {
        return new DateTime(date).toString(DEFAULT_DATE_TIME_PATTERN);
    }

    /**
     * 将指定的时间转换成字符串时间格式 <br/>
     * @param date Java的时间对象 {@link Date}
     * @param pattern 指定的时间格式
     * @return
     * 返回指定格式的时间字符串。如果pattern为null，则使用默认的时间格式："yyyy-MM-dd HH:mm:ss"
     */
    public static String formatDateTime(Date date, String pattern) {
        if (pattern == null) {
            return formatDateTime(date);
        }
        return new DateTime(date).toString(pattern);
    }

    /**
     * 将当前日期转换成字符串日期格式 <br/>
     * @return
     * 返回默认格式的日期字符串："yyyy-MM-dd" -- 例如："2018-01-05"
     */
    public static String formatDateNow() {
        return new LocalDate().toString(DEFAULT_DATE_PATTERN);
    }

    /**
     * 将指定的日期转换成字符串日期格式 <br/>
     * @return
     * 返回默认格式的日期字符串："yyyy-MM-dd" -- 例如："2018-01-05"
     */
    public static String formatDate(Date date) {
        return new LocalDate(date).toString(DEFAULT_DATE_PATTERN);
    }

    /**
     * 获将当前日期格式化成字符串日期格式 <br/>
     * @param pattern 指定的日期格式
     * @return
     * 返回指定格式的日期字符串。如果pattern为null，则使用默认的日期格式："yyyy-MM-dd"
     */
    public static String formatDateNow(String pattern) {
        if (pattern == null) {
            return formatDateNow();
        }
        return new LocalDate().toString(pattern);
    }

    /**
     * 将字符串时间转换成Java的时间对象 <br/>
     * @param dateTime 字符串时间，默认格式为："yyyy-MM-dd HH:mm:ss" -- 例如："2018-01-05 13:34:01"
     * @return
     * 返回Java的时间对象：{@link Date}
     */
    public static Date parseDateTime(String dateTime) {
        return DateTimeFormat
                .forPattern(DEFAULT_DATE_TIME_PATTERN)
                .parseDateTime(dateTime)
                .toDate();
    }

    /**
     * 将字符串时间转换成Java的时间对象 <br/>
     * @param dateTime 字符串时间，默认格式为："yyyy-MM-dd HH:mm:ss" -- 例如："2018-01-05 13:34:01"
     * @param pattern 指定的时间格式
     * @return
     * 返回Java的时间对象：{@link Date} <br/>
     * 如果pattern为null，则使用默认的时间格式对字符串时间进行解析
     */
    public static Date parseDateTime(String dateTime, String pattern) {
        if (pattern == null) {
            return parseDateTime(dateTime);
        }
        return DateTimeFormat
                .forPattern(pattern)
                .parseDateTime(dateTime)
                .toDate();
    }

    /**
     * 在当前的时间上增加指定的天数 <br/>
     * @param days 指定的天数
     * @return
     * 返回当前时间加上指定天数后的时间（字符串格式："yyyy-MM-dd HH:mm:ss"）
     */
    public static String plusDays2String(int days) {
        return new DateTime().plusDays(days).toString(DEFAULT_DATE_TIME_PATTERN);
    }

    /**
     * 在指定的时间上增加指定的天数 <br/>
     * @param date 指定的时间
     * @param days 指定的天数
     * @return
     * 返回指定时间加上指定天数后的时间（字符串格式："yyyy-MM-dd HH:mm:ss"）
     */
    public static String plusDays2String(Date date, int days) {
        return new DateTime(date).plusDays(days).toString(DEFAULT_DATE_TIME_PATTERN);
    }

    /**
     * 在当前的时间上增加指定的天数 <br/>
     * @param days 指定的天数
     * @return
     * 返回当前时间加上指定天数后的时间（Java的时间对象 {@link Date}）
     */
    public static Date plusDays2Date(int days) {
        return new DateTime().plusDays(days).toDate();
    }

    /**
     * 在指定的时间上增加指定的天数 <br/>
     * @param date 指定的时间
     * @param days 指定的天数
     * @return
     * 返回指定时间加上指定天数后的时间（Java的时间对象 {@link Date}）
     */
    public static Date plusDays2Date(Date date, int days) {
        return new DateTime(date).plusDays(days).toDate();
    }

    /**
     * 在当前的时间上增加指定的分钟数 <br/>
     * @param minutes 指定的分钟数
     * @return
     * 返回当前时间加上指定分钟数后的时间（字符串格式："yyyy-MM-dd HH:mm:ss"）
     */
    public static String plusMinutes2String(int minutes) {
        return new DateTime().plusMinutes(minutes).toString(DEFAULT_DATE_TIME_PATTERN);
    }

    /**
     * 在当前的时间上增加指定的分钟数 <br/>
     * @param minutes 指定的分钟数
     * @return
     * 返回当前时间加上指定分钟数后的时间（Java的时间对象 {@link Date}）
     */
    public static Date plusMinutes2Date(int minutes) {
        return new DateTime().plusMinutes(minutes).toDate();
    }

    /**
     * 在当前的时间上减去指定的天数
     * @param days 指定的天数
     * @return
     * 返回当前时间减去指定的天数后的时间（字符串格式："yyyy-MM-dd HH:mm:ss"）
     */
    public static String minusDays2String(int days) {
        return new DateTime().minusDays(days).toString(DEFAULT_DATE_TIME_PATTERN);
    }

    /**
     * 在指定的时间上减去指定的天数
     * @param date 指定的时间
     * @param days 指定的天数
     * @return
     * 返回指定时间减去指定的天数后的时间（字符串格式："yyyy-MM-dd HH:mm:ss"）
     */
    public static String minusDays2String(Date date, int days) {
        return new DateTime(date).minusDays(days).toString(DEFAULT_DATE_TIME_PATTERN);
    }

    /**
     * 在当前的时间上减去指定的天数
     * @param days 指定的天数
     * @return
     * 返回当前时间减去指定的天数后的时间（Java的时间对象 {@link Date}）
     */
    public static Date minusDays2Date(int days) {
        return new DateTime().minusDays(days).toDate();
    }

    /**
     * 在指定的时间上减去指定的天数
     * @param date 指定的时间
     * @param days 指定的天数
     * @return
     * 返回指定时间减去指定的天数后的时间（Java的时间对象 {@link Date}）
     */
    public static Date minusDays2Date(Date date, int days) {
        return new DateTime(date).minusDays(days).toDate();
    }

}
