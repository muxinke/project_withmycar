package com.qf.j1902.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by 杜碧天 on 2019/7/9.
 */
public class TimeZhuanHuan {
    public static String TimeZhDuan(String data) throws ParseException {
        String dateStr = data;
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        //java.util.Date对象
        Date date = (Date) sdf.parse(dateStr);
        //2009-09-16
        String formatStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return formatStr;
    }
    public static String TimeZhChang(String data) throws ParseException {
        String dateStr = data;
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        //java.util.Date对象
        Date date = (Date) sdf.parse(dateStr);

        //2009-09-16 11:26:23
        String formatStr2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
       return formatStr2;
    }

}
