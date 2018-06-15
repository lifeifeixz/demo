package com.baixiang.chuxing.user.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p/>
 * <p><b>introduction:</b>
 * </p>
 * <p><b>packageName:</b>com.st.user.utils</p>
 * <p><b>projectName:</b>maxmob</p>
 * <p><b>User:</b> lipengfei <a href="mailto:lipengfei90@live.cn">lipengfei90@live.cn</a></p>
 * <p><b>Date:</b>2016/5/13</p>
 *
 * @author lipengfei
 */
public class DateUtil {

    public static final Long ONE_DAY_SCOUNDS = 1L * 60 * 60 * 24;
    public static final Long ONE_DAY_MILLIS = 1000L * ONE_DAY_SCOUNDS;

    public static final String DATE_TYPE_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_TYPE_YYYYMMDDHH = "yyyyMMddHH";
    public static final String DATE_TYPE_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_TYPE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:st:ss";
    public static final String DATE_TYPE_HH_MM_SS = "HH:st:ss";
    public static final String DATE_TYPE_HH = "HH";


    public static Date getDate(Date date, String formatStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
        String dateStr = simpleDateFormat.format(date);
        try {
            Date newDate  = simpleDateFormat.parse(dateStr);
            return newDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
