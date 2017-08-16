package com.weather.simulate.model;

import java.util.Date;
import java.util.List;

/**
 * Input data model
 * 
 * @author gshankar
 *
 */
public class InputData {

	private String location;
	private List<Temperature> temperatureData;
	private List<Pressure> pressureData;
	private List<Humidity> humidityData;
	private Date startDate;
	private int numDays;
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Temperature> getTemperatureData() {
		return temperatureData;
	}
	public void setTemperatureData(List<Temperature> temperatureData) {
		this.temperatureData = temperatureData;
	}
	public List<Pressure> getPressureData() {
		return pressureData;
	}
	public void setPressureData(List<Pressure> pressureData) {
		this.pressureData = pressureData;
	}
	public List<Humidity> getHumidityData() {
		return humidityData;
	}
	public void setHumidityData(List<Humidity> humidityData) {
		this.humidityData = humidityData;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getNumDays() {
		return numDays;
	}
	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}
	
}
