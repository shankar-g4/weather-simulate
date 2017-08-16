package com.weather.simulate.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	ConditionUtilsTest.class, 
	DateUtilTest.class, 
	WeatherGeneratorTest.class,
	WeatherPredictorTest.class,
})
public class AllTests {

}

