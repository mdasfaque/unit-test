package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SomeBusinessTest {
	
	@Test
	public void calculateSum_basic() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualvalue = business.calculateSum(new int[] {1,2,3});
		int expectedvalue = 6;
		assertEquals(expectedvalue,actualvalue);
		
	}
	@Test
	public void calculateSum_empty() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualvalue = business.calculateSum(new int[] { });
		int expectedvalue = 0;
		assertEquals(expectedvalue,actualvalue);
		
	}
	@Test
	public void calculateSum_onevalue() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualvalue = business.calculateSum(new int[] {1});
		int expectedvalue = 1;
		assertEquals(expectedvalue,actualvalue);
		
	}

}
