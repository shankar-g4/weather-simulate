package com.weather.simulate.test;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.weather.simulate.util.DateUtil;

public class DateUtilTest {
	
	@Before
	public void prepare() {
	}

	@Test
	public void getMonthTest() {
		Date date = new Date();
		assert(DateUtil.getMonth(date)==7);
	}
	@Test
	public void getMonthForInt () {
		Date date = new Date();
		int monthInt = DateUtil.getMonth(date);
		String monthStr = DateUtil.getMonthForInt(monthInt);
		System.out.println(monthStr);
		assert(monthStr.equals("August"));
	}
	@After
	public void close(){
		
	}
}
