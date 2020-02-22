package com.zjuqsc.qscdap.util;

import java.util.Calendar;
import java.util.Date;


public class TimeUtils {

    public static boolean isExpired(Date expireTime) {
        return new Date().after(expireTime);
    }

    public static Date addDays(Date currentTime, int daysToAdd){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTime);
        calendar.add(Calendar.DATE, daysToAdd);

        return calendar.getTime();
    }
}
