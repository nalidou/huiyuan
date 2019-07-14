package com.jujingyun.huiyuan.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具
 */
public class TimeUtil {

    //24小时制
    public static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat timeFormatNum = new SimpleDateFormat("yyyyMMddHHmmss");
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // 1562752907386 -> 2019-07-10 18:01:47
    public static String time2TimeStr(long time){
        return timeFormat.format(new Date(time));
    }

    // 1562752907386 -> 20190710180147
    public static String time2TimeStrNum(long time){
        return timeFormatNum.format(new Date(time));
    }

    // 1562752907386 -> 2019-07-10
    public static String time2DateStr(long time){
        return dateFormat.format(new Date(time));
    }

    // 2019-07-10 18:01:47 -> 1562752907000
    public static long timeStr2Time(String time){
        try {
            return timeFormat.parse(time).getTime();
        } catch (Exception e) {
            return 0L;
        }

    }

    //2019-07-10  -> 1562688000000
    public static long dateStr2Time(String date) {
        try {
            return dateFormat.parse(date).getTime();
        } catch (Exception e) {
            return 0L;
        }

    }


}
