package be.ehb.digx.refuel.util;


import com.android.annotations.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by richsoft on 21/11/2016.
 */

public class DateTime {

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String TIME_FORMAT = "HH:mm";

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

    public static String getDate(Long timeStamp){
        Date date=new Date(timeStamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        String dateText = dateFormat.format(date);
        return dateText;

    }

    public static String getTime(Long timeStamp){
        Date date=new Date(timeStamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        String timeText = dateFormat.format(date);
        return timeText;
    }
}