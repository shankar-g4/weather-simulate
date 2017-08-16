package com.weather.simulate.constants;

/**
 * Constants used in the application
 * 
 * @author gshankar
 *
 */
public class WeatherConstant {

	public static final String MM_DD_YYYY = "MM/dd/yyyy";
	public static final String COMMA_SEPERATOR =  ",";
	public static final int ARIMA_PARAM_p = 3;
	public static final int ARIMA_PARAM_d = 0;
	public static final int ARIMA_PARAM_q = 3;
	public static final int ARIMA_PARAM_P = 1;
	public static final int ARIMA_PARAM_D = 1;
	public static final int ARIMA_PARAM_Q = 0;
	public static final int ARIMA_PARAM_m = 0;
	public static final String PIPE_SEPERATOR = "|";
	public static final String RAIN = "Rain";
	public static final String SNOW = "Snow";
	public static final String SUNNY = "Sunny";
	public static final String DETAILS_JSON = "details.json";
	public static final String INPUT_DIR = "input";
	public static final String DOT_CSV = ".csv";
	public static final String LOCATIONS_TXT = "locations.txt";
	public static final String INVALID_ARGUMENTS = "Parameters not enough!\n\tThis application requires 3 parameters..\n"
					+ "\tAn absolute path of the file containing row data, a start date, a duration, and an outputPath.\n"
					+ "Usage : java -cp weather-simulate.jar Main 2018-07-20 10 output.txt";
	public static final String INVALID_DATE = "Date must be a future date!";
}
