package com.weather.simulate.predict;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.simulate.constants.WeatherConstant;
import com.weather.simulate.model.GeneratedData;
import com.weather.simulate.model.Humidity;
import com.weather.simulate.model.InputData;
import com.weather.simulate.model.Location;
import com.weather.simulate.model.OutputData;
import com.weather.simulate.model.Pressure;
import com.weather.simulate.model.Temperature;
import com.weather.simulate.reader.InputDataReader;
import com.weather.simulate.util.ConditionsUtil;
import com.weather.simulate.util.DateUtil;
import com.weather.simulate.util.FileUtil;


/**
 * Generates output based on timeseries forecasting
 * Uses ARIMA implementation by workday for seasonal data
 * 
 * @author gshankar
 *
 */
public class WeatherGenerator {
	
	InputDataReader inputReader;
	DecimalFormat decimalFormat = new DecimalFormat("#.##");

	/**
	 * argument Constructor
	 * @param inpReader
	 */
	public WeatherGenerator(InputDataReader inpReader) {
		this.inputReader = inpReader;
	}

	/**
	 * prepares input for forecast method 
	 * calls the forecast method
	 * @return list of GeneratedData instances 
	 */
	public OutputData generate() {
		InputData inpData = inputReader.getInputData();
		List<Temperature> tempList = inpData.getTemperatureData();
		List<Pressure> pressureList = inpData.getPressureData();
		List<Humidity> humidityList = inpData.getHumidityData();
		int inpDataSize = tempList.size();
		// Prepare input timeseries data.
		double[] tempVals = new double[inpDataSize];
		double[] prssureVals = new double[inpDataSize];
		double[] humidityVals = new double[inpDataSize] ;
		int i = 0;
		while (i < tempList.size()) {
			tempVals[i] = tempList.get(i).getValue();
			prssureVals[i] = pressureList.get(i).getValue();
			humidityVals[i] = humidityList.get(i).getValue();
			i++;
		}
		int numDays = inpData.getNumDays();
		//Call forecast method
		WeatherPredictor weatherPredictor = new WeatherPredictor();
		double[] temperatureOutput = weatherPredictor.getForecastData(numDays, tempVals);
		double[] pressureOutput = weatherPredictor.getForecastData(numDays, prssureVals);
		double[] humidityOutput = weatherPredictor.getForecastData(numDays, humidityVals);
		//Prepare output to return
		List<GeneratedData> generatedDataList = new ArrayList<GeneratedData>();
		GeneratedData generatedData;
		int j = 0;
		while(j < inpData.getNumDays()) {
			generatedData = new GeneratedData();
			String date = DateUtil.incrementDate(inpData.getStartDate(), j);
			generatedData.setDate(date);
			generatedData.setTemperature(decimalFormat.format(temperatureOutput[j]));
			generatedData.setPressure(decimalFormat.format(pressureOutput[j]));
			generatedData.setHumidity(decimalFormat.format(humidityOutput[j]));
			generatedData.setCondition(ConditionsUtil.getCondition(DateUtil.getMonth(inpData.getStartDate()), temperatureOutput[j], humidityOutput[j]));
			generatedDataList.add(generatedData);
			j++;
		}
		OutputData outputData = new OutputData();
		outputData.setGeneratedData(generatedDataList);
		String filepath = WeatherConstant.INPUT_DIR+"/"+inpData.getLocation().toUpperCase()+"/"+WeatherConstant.DETAILS_JSON;
		InputStream is = new FileUtil().getResourceFile(filepath);
		
		ObjectMapper mapper = new ObjectMapper();
		Location loc = new Location();
		try {
			loc = mapper.readValue(is, Location.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		outputData.setLocationName(loc.getName());
		outputData.setLongitude(loc.getLongitude());
		outputData.setLatitude(loc.getLatitude());
		outputData.setElevation(loc.getElevation());
		
		return outputData;
		
	}


}
