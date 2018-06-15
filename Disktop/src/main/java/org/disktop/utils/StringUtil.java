package org.disktop.utils;

import java.util.Objects;
import java.util.Random;

/**
 * Created by flysLi on 2017/8/26.
 */
public class StringUtil {

    /**
     * 非空判断,去除空格
     *
     * @param str
     * @return
     */
    public static boolean notNull(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return true;
    }

    /**
     * 等空判断
     *
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static Long randomId() {
        return System.currentTimeMillis() + new Random().nextInt(10000);
    }
}
