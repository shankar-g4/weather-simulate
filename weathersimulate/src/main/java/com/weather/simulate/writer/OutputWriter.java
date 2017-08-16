package com.weather.simulate.writer;

import java.util.ArrayList;
import java.util.List;

import com.weather.simulate.constants.WeatherConstant;
import com.weather.simulate.model.GeneratedData;
import com.weather.simulate.model.OutputData;

/**
 * Has methods to write the output data contained in OutputData model object
 * into output file
 * 
 * 
 * @author shankar
 *
 */
public class OutputWriter {

	OutputData outputData;

	/**
	 * @param outputData the model object containing the output data
	 * @return 
	 */
	public List<String> write(OutputData outputData) {
		this.outputData = outputData;
		List<String> lines = new ArrayList<String>();
		List<GeneratedData> generatedDataList = outputData.getGeneratedData();
		StringBuilder sb = new StringBuilder();
		// Iterate for each day 
		for(int i = 0; i < generatedDataList.size(); i++) {
			sb = sb.append(outputData.getLocationName()).append(WeatherConstant.PIPE_SEPERATOR)
					.append(outputData.getLatitude()).append(WeatherConstant.COMMA_SEPERATOR)
					.append(outputData.getLongitude()).append(WeatherConstant.COMMA_SEPERATOR)
					.append(outputData.getElevation()).append(WeatherConstant.PIPE_SEPERATOR)
					.append(outputData.getGeneratedData().get(i).getDate()).append(WeatherConstant.PIPE_SEPERATOR)
					.append(outputData.getGeneratedData().get(i).getCondition()).append(WeatherConstant.PIPE_SEPERATOR)
					.append(outputData.getGeneratedData().get(i).getTemperature()).append(WeatherConstant.PIPE_SEPERATOR)
					.append(outputData.getGeneratedData().get(i).getPressure()).append(WeatherConstant.PIPE_SEPERATOR)
					.append(outputData.getGeneratedData().get(i).getHumidity());
			System.out.println(sb.toString());
			lines.add(sb.toString());
			sb = new StringBuilder();
		}
		return lines;
	}

}
