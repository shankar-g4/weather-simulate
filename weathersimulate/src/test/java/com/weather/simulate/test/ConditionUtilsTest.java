package com.weather.simulate.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.weather.simulate.constants.WeatherConstant;
import com.weather.simulate.util.ConditionsUtil;

public class ConditionUtilsTest {
	
	int month = 10;
	double temperature = 27.5;
	double humidity = 90;

	@Before
	public void prepare() {
		month = 10;
		temperature = 27.5;
		humidity = 90;
	}
	
	@Test
	public void testGetCondition () {
		assert(ConditionsUtil.getCondition(month, temperature, humidity).equals(WeatherConstant.SUNNY));
		
	}

	@After
	public void close(){
		
	}
}
