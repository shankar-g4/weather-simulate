package com.weather.simulate.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.weather.simulate.constants.WeatherConstant;
import com.weather.simulate.model.InputData;
import com.weather.simulate.model.OutputData;
import com.weather.simulate.predict.WeatherGenerator;
import com.weather.simulate.reader.InputDataReader;
import com.weather.simulate.util.DateUtil;
import com.weather.simulate.util.FileUtil;
import com.weather.simulate.util.WeatherUtil;
import com.weather.simulate.writer.OutputWriter;

/**
 * 
 * This application generates a set of outcomes for weather data based on a prediction model
 * Weather is a seasonal data; the prediction for such data needs a timeseries algorithm
 * This application makes use of an ARIMA implementation to generate weather parameters
 * such as temperature, pressure and humidity based on a set of inputs
 * 
 *  Inputs for the application consists of
 *  1. Recorded weather data for the locations for all months
 *  2. Start Date from which the prediction begins
 *  3. Number of days for which weather details need to be generated
 *  4. Location details which includes latitude, longitude and elevation
 *  5. Set of locations whose prediction data is required
 *  
 *  For each location,
 *  Based on the start date argument, InputDataReader loads the input files,
 *  reads the csv input files and stores it in model InputData
 *  WeatherGenerator generates all output data along with prediction results
 *  stores all output in OutputData model object
 *  OutputWriter writes the output data to output file
 *  
 * 
 * @author gshankar
 *
 */
public class Main {
	
	static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main (String[] args) {
		//check for the input arguments
		if (args == null || args.length < 3) {
			logger.severe(WeatherConstant.INVALID_ARGUMENTS);
			System.exit(1);
		}
		//validate the date
		String startDateStr = args[0];
		if(!DateUtil.isValidDate(startDateStr)) {
			logger.severe(WeatherConstant.INVALID_DATE);
			System.exit(1);
		}
		
		//get all locations from file
		List<String> locations = new WeatherUtil().getLocations();
		String outFilepath = args[2]; // output file path
		WeatherUtil.clearOutFile(outFilepath); //clear output file
		//Iterate for each location
		for(String location : locations) {
			String numDays = args[1]; // number of days
			List<String> monthList = new ArrayList<String>();
			List<File> fileList = new ArrayList<File>();	
			List<String> filepathList = new ArrayList<String>();
			Date startDate = DateUtil.stringToDate(startDateStr);
			int month = DateUtil.getMonth(startDate);
			monthList.add(DateUtil.getMonthForInt(month-1));
			monthList.add(DateUtil.getMonthForInt(month));
			for(String mnth : monthList) {
//				File file = new File(WeatherUtil.getInputFile(location, mnth));
				String filepath = WeatherUtil.getInputFile(location, mnth);
//				fileList.add(file);
				filepathList.add(filepath);
			}
			InputData inputData = new InputData();
			inputData.setLocation(location);
			inputData.setNumDays(Integer.parseInt(numDays));
			inputData.setStartDate(startDate);
			
			InputDataReader inpDataReader = new InputDataReader(filepathList, inputData);
			WeatherGenerator weatherGenerator = new WeatherGenerator(inpDataReader);
			OutputData weatherOutput = weatherGenerator.generate();
			OutputWriter outputWriter = new OutputWriter();
			List<String> lines = outputWriter.write(weatherOutput);
			FileUtil.writeToFile(outFilepath, lines);
			
		}
		
	}

	
}
