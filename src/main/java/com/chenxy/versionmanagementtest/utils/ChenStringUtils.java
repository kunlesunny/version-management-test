package com.chenxy.versionmanagementtest.utils;

/**
 * 我自己的String工具包
 */
public class ChenStringUtils {

    /**
     * 判断多个字符串是否都不为空
     * @param strings
     * @return
     */
    public static boolean isNoNullAndNotEmpty(String... strings) {
        for (String str : strings) {
            if (str == null || "".equals(str)) {
                return false;
            }
        }
        return true;
    }
}
