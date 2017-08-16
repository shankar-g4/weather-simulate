package com.weather.simulate.predict;

import com.weather.simulate.constants.WeatherConstant;
import com.workday.insights.timeseries.arima.Arima;
import com.workday.insights.timeseries.arima.struct.ArimaParams;
import com.workday.insights.timeseries.arima.struct.ForecastResult;

public class WeatherPredictor {
	/**
	 * getting the forecast data based on an array of inputVals
	 * uses ARIMA implementation of com.workday.insights.timeseries
	 * @param numDays the number of values need to be predicted
	 * @param inpVals the array of input values
	 * @return array of forecasted values
	 */
	public double[] getForecastData(int numDays, double[] inpVals) {
		// Set ARIMA model parameters.
		int p = WeatherConstant.ARIMA_PARAM_p;
		int d = WeatherConstant.ARIMA_PARAM_d;
		int q = WeatherConstant.ARIMA_PARAM_q;
		int P = WeatherConstant.ARIMA_PARAM_P;
		int D = WeatherConstant.ARIMA_PARAM_D;
		int Q = WeatherConstant.ARIMA_PARAM_Q;
		int m = WeatherConstant.ARIMA_PARAM_m;
		int forecastSize = numDays;
		ArimaParams arimaParams = new ArimaParams(p, d, q, P, D, Q, m);
		
		// Obtain forecast result. The structure contains forecasted values and performance metric etc.
		ForecastResult forecastResult = Arima.forecast_arima(inpVals, forecastSize, arimaParams);

		// Read forecast values
		double[] forecastData = forecastResult.getForecast();
		return forecastData;
	}
}
