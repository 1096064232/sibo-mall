package cn.ouyangfan.mall.sibo.core.util;

import cn.hutool.core.date.DateUtil;

public class DateUtils {

    /**
     * 精确到秒的时间串
     *
     * @return 精确到秒的时间串
     */
    public static String getCurrentTimeSeriesToSecond() {
        return DateUtil.format(DateUtil.date(), "yyyyMMddHHmmss");
    }

    /**
     * 精确到毫秒的时间串
     *
     * @return 精确到毫秒的时间串
     */
    public static String getCurrentTimeSeriesToMillisecond() {
        return DateUtil.format(DateUtil.date(), "yyyyMMddHHmmssmmm");
    }

}
