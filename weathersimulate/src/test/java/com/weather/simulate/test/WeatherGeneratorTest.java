package com.weather.simulate.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.weather.simulate.model.GeneratedData;
import com.weather.simulate.model.InputData;
import com.weather.simulate.model.Temperature;
import com.weather.simulate.predict.WeatherGenerator;
import com.weather.simulate.reader.InputDataReader;

public class WeatherGeneratorTest {

	InputDataReader inputReader;
	InputData inputData = new InputData();
	WeatherGenerator weatherGenerator;
	List<String> listOfFiles = new ArrayList<String>();
	
	@Before
	public void initObject(){
		List<Temperature> temperatureData = getTemperatureTestData();
		inputData.setNumDays(2);
		inputData.setStartDate(new Date());
		inputData.setTemperatureData(temperatureData);
		inputData.setLocation("adelaide");
		listOfFiles.add("input/ADELAIDE/nov.csv");
		inputReader = new InputDataReader(listOfFiles, inputData);
		weatherGenerator = new WeatherGenerator(inputReader);
	}
	
	private List<Temperature> getTemperatureTestData() {
		List<Temperature> temperatureData = new ArrayList<Temperature>();
		for(int i = 0; i < 10 ; i++) {
			Temperature temperature = new Temperature();
			temperature.setValue(25);
			temperatureData.add(temperature);
		}
		return temperatureData;
	}

	@Test
	public void generateTest() {
		List<GeneratedData> generatedData = weatherGenerator.generate().getGeneratedData();
		assert(generatedData.size()==2); // Got data for 2 days
	}

	@After
	public void close(){
		inputReader = null;
		weatherGenerator = null;
	}

}
