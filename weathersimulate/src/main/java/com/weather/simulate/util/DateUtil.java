package com.weather.simulate.util;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.weather.simulate.constants.WeatherConstant;

/**
 * 
 * Date Utilitiles
 * 
 * @author gshankar
 *
 */
public class DateUtil {

	Logger logger = Logger.getLogger(DateUtil.class.getName());
	static SimpleDateFormat dateFormatter = new SimpleDateFormat(WeatherConstant.MM_DD_YYYY);
	
	/**
	 * method converts a date string to java.util.Date format
	 * 
	 * @param dateStr - string representation of date
	 * @return formatted date as java.util.Date instance
	 */
	public static Date stringToDate(String dateStr) {
		Date startDate = null;
		try {
			startDate = dateFormatter.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return startDate;
		
	}

	/**
	 * method returns int value of month for an input date
	 * 
	 * @param date instance of java.util.Date
	 * @return int value of the month in the input date
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH);
		return month;
	}
	
	
	/**
	 * @param monthInt int value of month
	 * @return name of the month
	 */
	public static String getMonthForInt(int monthInt) {
	        String month = "wrong";
	        DateFormatSymbols dfs = new DateFormatSymbols();
	        String[] months = dfs.getMonths();
	        if (monthInt >= 0 && monthInt <= 11 ) {
	            month = months[monthInt];
	        }
	        return month;
	    }

	/**
	 * @param date instance of java.util.Date
	 * @return day of the month
	 */
	public static int getDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		return dayOfMonth;
	}

	/**
	 * @param startDate
	 * @param daysToAdd
	 * @return string representaton of date in yyyy-MM-dd HH:mm:ss format
	 * for example 2015-12-23 16:02:12
	 */
	public static String incrementDate(Date startDate, int daysToAdd) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.DATE, daysToAdd);  // number of days to add
		calendar.add(Calendar.HOUR_OF_DAY, 9);
		calendar.add(Calendar.MINUTE, 30);
		String dateStr = null;
		dateStr = DateFormatUtils.format(calendar.getTime(), "yyyy-MM-dd HH:mm:ss");
		return dateStr;
	}
	
	public static boolean isValidDate(String dateStr) {
		return DateUtil.stringToDate(dateStr).after(new Date());
	}

	
}
