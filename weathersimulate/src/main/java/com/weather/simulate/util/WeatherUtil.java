package com.weather.simulate.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.weather.simulate.constants.WeatherConstant;

/**
 * Utility class to help the main execution
 * 
 * @author shankar
 *
 */
public class WeatherUtil {
	
	/**
	 * @return list of locations to perform weather prediction
	 */
	public List<String> getLocations(){
		List<String> locations = new ArrayList<String>();
		try {
			InputStream is = this.getClass().getClassLoader()
                    .getResourceAsStream(WeatherConstant.LOCATIONS_TXT);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String location = null;
			while(null!=(location = br.readLine())) {locations.add(location);}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return locations;
	}

	/**
	 * prepare filepath for the required location and month
	 * @param location
	 * @param month
	 * @return string path of the input csv file
	 */
	public static String getInputFile(String location, String month) {
		return WeatherConstant.INPUT_DIR+"/"+location.toUpperCase()+"/"+month.toLowerCase().substring(0, 3)+WeatherConstant.DOT_CSV;
	}

	/**
	 * clears the output file for every execution
	 * @param outputPath 
	 */
	public static void clearOutFile(String outputPath) {
		Path file = Paths.get(outputPath);
		try {
			Files.deleteIfExists(file);
			Files.createFile(file);
		} catch (FileAlreadyExistsException ignored) {
			ignored.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
}
