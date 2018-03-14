package com.itaem.serpit.helpbuy;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    private static String getString(Calendar c)
    {
        StringBuffer result = new StringBuffer();
        result.append(c.get(Calendar.YEAR));
        result.append("-");
        result.append((c.get(Calendar.MONTH) + 1));
        result.append("-");
        result.append(c.get(Calendar.DAY_OF_MONTH));
        result.append(" ");
        result.append(c.get(Calendar.HOUR_OF_DAY));
        result.append(":");
        result.append(c.get(Calendar.MINUTE));
        result.append(":");
        result.append(c.get(Calendar.SECOND));
        return result.toString();
    }
    @Test
    public void test() throws Exception{
        try

        {

            String ts = "2007-10-23T17:15:44.000Z";

            System.out.println("ts = " + ts);

            ts = ts.replace("Z", " UTC");

            System.out.println("ts = " + ts);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");

            Date dt = sdf.parse(ts);


            TimeZone tz = sdf.getTimeZone();
            Calendar c = sdf.getCalendar();
            System.out.println("Display name: " +
                    tz.getDisplayName());

            System.out.println(getString(c));

        }

        catch(ParseException pe)

        {

            System.out.println("Error offset: " + pe.getErrorOffset());

            pe.printStackTrace();

        }

    }


    @Test
    public void test2() throws Exception{
//        "2018-02-22T10:46:42.464Z"

    }
}