package com.weather.simulate.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.weather.simulate.predict.WeatherPredictor;

public class WeatherPredictorTest {

	WeatherPredictor weatherPredictor = new WeatherPredictor();
	double[] inpVals;
	
	@Before
	public void prepare() {
		inpVals = new double[] {25, 25, 25, 25, 25, 25, 25, 25, 25,
				25, 25, 25, 25, 25, 25, 25, 25, 25,};
	}
	@Test
	public void getForecastData () {
		double[] forcastResult = weatherPredictor.getForecastData(5, inpVals);
		double[] expectedResult = new double[] {25, 25, 25, 25, 25};
		Assert.assertArrayEquals(expectedResult, forcastResult, 5);
	}
	
	@After
	public void close () {
		inpVals = null;
	}
}
