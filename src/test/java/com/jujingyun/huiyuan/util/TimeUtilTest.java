package com.jujingyun.huiyuan.util;

import com.jujingyun.huiyuan.common.util.TimeUtil;

import java.text.ParseException;
import java.util.Date;

public class TimeUtilTest {

    public static void main(String[] args) throws ParseException {
        long now = System.currentTimeMillis();
        String nowStr = TimeUtil.timeFormat.format(new Date(now));
        String nowStr1 = TimeUtil.dateFormat.format(new Date(now));

        //System.out.println(now);

        //System.out.println(nowStr);
        //System.out.println(nowStr1);
        //System.out.println("----------------------");

        //System.out.println(TimeUtil.timeFormat.parse(nowStr).getTime());
        //System.out.println(TimeUtil.timeFormat.parse(nowStr1).getTime());
        //System.out.println("----------------------");
        //System.out.println(TimeUtil.dateFormat.parse(nowStr).getTime());
        //System.out.println(TimeUtil.dateFormat.parse(nowStr1).getTime());

        //System.out.println(TimeUtil.sdf.format(new Date()));
        //System.out.println(TimeUtil.sdf.format(new Date()));

        System.out.println(getSexStr(1));
        System.out.println(getSexStr(2));
        System.out.println(getSexStr(3));

    }

    public static String getSexStr(int sex) {
        return sex == 1 ? "男" : sex == 2 ? "女" : "未知";
    }
}
