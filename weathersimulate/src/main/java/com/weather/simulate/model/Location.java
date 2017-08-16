package com.weather.simulate.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model object for json file containing location details
 * uses com.fasterxml.jackson
 * 
 * @author shankar
 *
 */
public class Location {

	@JsonProperty("name")
	String name;
	@JsonProperty("latitude")
	String latitude;
	@JsonProperty("longitude")
	String longitude;
	@JsonProperty("elevation")
	String elevation;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
}
