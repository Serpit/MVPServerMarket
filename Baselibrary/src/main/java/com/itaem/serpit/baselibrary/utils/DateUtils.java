package com.itaem.serpit.baselibrary.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2018/2/22 0022.
 */

public class DateUtils {
    public static String format(String date) throws Exception{

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        format.parse(date);

        Calendar c = format.getCalendar();
        return  c.get(Calendar.YEAR)+"-"+(c.get(Calendar.MONTH)+1)+"-"+c.get(Calendar.DAY_OF_MONTH)+"T"
                +c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND)+".000Z";

    }

    public static String getCurrentTime(){
        Calendar calendar = Calendar.getInstance();
        StringBuilder builder = new StringBuilder();
        builder.append(calendar.get(Calendar.YEAR));
        builder.append("-");
        builder.append(calendar.get(Calendar.MONTH)+1);
        builder.append("-");
        builder.append(calendar.get(Calendar.DAY_OF_MONTH));
        builder.append(" ");
        builder.append(calendar.get(Calendar.HOUR_OF_DAY));
        builder.append(":");
        builder.append(calendar.get(Calendar.MINUTE));
        builder.append(":");
        builder.append(calendar.get(Calendar.SECOND));

        return builder.toString();
    }


}
