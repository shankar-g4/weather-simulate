package com.weather.simulate.model;

import java.util.List;

/**
 * Model object for containing the output data to be written to file
 * 
 * @author shankar
 *
 */
public class OutputData {

	String locationName;
	String latitude;
	String longitude;
	String elevation;
	List<GeneratedData> generatedData;
	
	
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getElevation() {
		return elevation;
	}
	public void setElevation(String elevation) {
		this.elevation = elevation;
	}
	public List<GeneratedData> getGeneratedData() {
		return generatedData;
	}
	public void setGeneratedData(List<GeneratedData> generatedData) {
		this.generatedData = generatedData;
	}
	
}
