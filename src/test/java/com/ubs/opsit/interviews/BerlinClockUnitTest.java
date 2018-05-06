package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BerlinClockUnitTest {
	
	private BerlinClock clock;
	
	@Before
	public void setup(){
		clock = new BerlinClock();
	}
	
	@Test
	public void testMidnight(){
		Assert.assertEquals("Y\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO", clock.convertTime("00:00:00"));
	}
	
	@Test
	public void testMidnight1(){
		Assert.assertEquals("FailTest", clock.convertTime("00:00:00"));
	}
	
}
