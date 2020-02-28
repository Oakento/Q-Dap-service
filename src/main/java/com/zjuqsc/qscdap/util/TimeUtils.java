package com.zjuqsc.qscdap.util;

import com.zjuqsc.qscdap.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;

public class TimeUtils {

    public static Date addDays(Date currentTime, int hourToAdd){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTime);
        calendar.add(Calendar.HOUR, hourToAdd);

        return calendar.getTime();
    }

}
