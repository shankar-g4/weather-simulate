package com.weather.simulate.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.weather.simulate.model.Humidity;
import com.weather.simulate.model.InputData;
import com.weather.simulate.model.Pressure;
import com.weather.simulate.model.Temperature;
import com.weather.simulate.util.DateUtil;

/**
 * Read data from list of input files using opencsv CSVReader
 * Parse the data to model object InputData
 * 
 * @author gshankar
 *
 */
public class InputDataReader {
	
	 InputData inputData;

	/**
	 * argument Constructor
	 * 
	 * @param fileList the list of files to read
	 * @param inputData the model object to store the read data
	 */
	public InputDataReader(List<String> fileList, InputData inputData) {
		this.inputData = inputData;
        String[] line;
        List<Temperature> tempList = new ArrayList<Temperature>();
        List<Humidity> humidityList = new ArrayList<Humidity>();
        List<Pressure> pressureList = new ArrayList<Pressure>();
        int iter = 1;
        int monthDay = 28;
        for(String filepath : fileList) {
        	
        	try {
				
				/*ClassLoader classLoader = getClass().getClassLoader();
				file = new File(classLoader.getResource(file.getPath()).getFile());*/
				InputStream is = getClass().getClassLoader().getResourceAsStream(filepath);
				@SuppressWarnings("resource")
				CSVReader csvReader = new CSVReader(new InputStreamReader(is));
				
				if(iter == 2 && DateUtil.getDayOfMonth(inputData.getStartDate())!=1) {
					monthDay = DateUtil.getDayOfMonth(inputData.getStartDate())-1;
				}
				csvReader.readNext();//skip headers
				for(int i = 0; i < monthDay ; i++) {
//				while(null!=csvReader.readNext()) {
					line = csvReader.readNext();
					Temperature temp = new Temperature();
					temp.setValue(new Double(line[9]));
					tempList.add(temp);
					
					Humidity humidity = new Humidity();
					humidity.setValue(new Double(line[10]));
					humidityList.add(humidity);
					
					Pressure pressure = new Pressure();
					pressure.setValue(new Double(line[14]));
					pressureList.add(pressure);
				}
				
				iter++;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
        inputData.setTemperatureData(tempList);
		inputData.setPressureData(pressureList);
		inputData.setHumidityData(humidityList);
	}
	
	/**
	 * @return model object with data
	 */
	public InputData getInputData() {
		return inputData;
	}
	
}
