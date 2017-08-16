package com.weather.simulate.util;

import com.weather.simulate.constants.WeatherConstant;

/** 
 * Generates the weather-condition
 * weather-condition is arrived at based on temperature and humidity values
 * 
 * @author shankar
 *
 */
public class ConditionsUtil {
	
	/**
	 * @param month of the year
	 * @param temperature value at the instance
	 * @param humidity value at the instance
	 * @return a weather condition - Rain, Snow or Sunny
	 */
	public static String getCondition(int month, double temperature, double humidity){
		
		boolean isRaining =false;
		
		if (month > 1 && month < 8 && humidity > 75) {
			isRaining = true;
		}
		else if (month > 10 && month < 2 && humidity > 82) {
			isRaining = true;
		}
		if (isRaining) {
			if (temperature>0) {
				return WeatherConstant.RAIN;
			}
			else return WeatherConstant.SNOW;
		}
		else {
			return WeatherConstant.SUNNY;
		}
	}
}

