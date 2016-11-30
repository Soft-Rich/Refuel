package be.ehb.digx.refuel.util;


import com.android.annotations.NonNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by richsoft on 21/11/2016.
 */

public class DateTime {

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String DATE_FORMAT_MONTH_YEAR = "MM/yyyy";
    private static final String TIME_FORMAT = "HH:mm";

    public static long getMonthYearId(String monthYear){
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_MONTH_YEAR);
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(monthYear);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsedDate.getTime();
    }

    public static Long getCurrentTimestamp() {

        return System.currentTimeMillis();

    }

    public static String getCurrentDate() {

        return new SimpleDateFormat(DATE_FORMAT).format(new Date());

    }

    public static String getCurrentTime() {
        return new SimpleDateFormat(TIME_FORMAT).format(new Date());
    }

    public static Long getTimestamp(@NonNull String date,@NonNull String time){
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT+" "+TIME_FORMAT);
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(date+" "+time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsedDate.getTime();
    }

    public static String getMothYear(long timeStamp){
        Date date=new Date(timeStamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_MONTH_YEAR);
        String dateText = dateFormat.format(date);
        return dateText;
    }

    public static String getDate(long timeStamp){
        Date date=new Date(timeStamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        String dateText = dateFormat.format(date);
        return dateText;

    }

    public static String getTime(long timeStamp){
        Date date=new Date(timeStamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        String timeText = dateFormat.format(date);
        return timeText;
    }

    public static Date getDateFromString(String date){
        DateFormat format = new SimpleDateFormat(DATE_FORMAT);
        Date resultDate = null;
        try {
            resultDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;

    }

    public static Date getTimeFromString(String time){
        DateFormat format = new SimpleDateFormat(TIME_FORMAT);
        Date resultTime = null;
        try {
            resultTime = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultTime;
    }
}
