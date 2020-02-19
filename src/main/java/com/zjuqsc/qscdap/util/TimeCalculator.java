package com.zjuqsc.qscdap.util;

import java.util.Calendar;
import java.util.Date;


public class TimeCalculator {

    public static boolean isExpired(Date expireTime) {
        Date now = new Date();
        return now.after(expireTime);
    }

    public static Date addDays(Date currentTime, int daysToAdd){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTime);
        calendar.add(Calendar.DATE, daysToAdd);

        Date newTime = calendar.getTime();

        return newTime;
    }
}
