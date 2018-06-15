package org.server.server3.logs;

import java.util.Date;

/**
 * Created by flysLi on 2017/8/14.
 */
public class Logger {

    /**
     * 日志打印
     * @param msg
     */
    public static void log(String msg) {
        System.out.println(new Date() + " : " + msg);
    }
}
