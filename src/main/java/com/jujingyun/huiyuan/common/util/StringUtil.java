package com.jujingyun.huiyuan.common.util;

public class StringUtil {

    public static boolean isBlack(String str){
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;

    }
}
