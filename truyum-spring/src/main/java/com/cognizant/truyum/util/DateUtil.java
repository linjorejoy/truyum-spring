package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public Date convertToDate(String date) {
		
		Date parsedDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		try {
			parsedDate = formatter.parse(date);
			
		} catch (ParseException e) {
			
			System.out.println("Date not in correct Format");
			e.printStackTrace();
		}
		return parsedDate;
	}
}
