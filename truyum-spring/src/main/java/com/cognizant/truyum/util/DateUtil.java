package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author LINJO
 *
 */
public class DateUtil {
    /**
     * To Convert any String in dd/MM/yyyy format to 
     * {@link java.util.Date} Object
     * 
     * @param   date date in specified string format
     * @return  {@link java.util.Date} Object
     */
    public Date convertToDate(final String date) {

        Date parsedDate = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            parsedDate = formatter.parse(date);

        } catch (ParseException e) {

            System.out.println("Date not in correct Format");
            e.printStackTrace();
        }
        return parsedDate;
    }
}
