package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
class someDataServiceStub implements SomeDataService{

	@Override
	public int[] retriveAllData() {
		// TODO Auto-generated method stub
		return new int[] {1,2,3};
	}
	
}
class someDataServiceEmptyStub implements SomeDataService{

	@Override
	public int[] retriveAllData() {
		// TODO Auto-generated method stub
		return new int[] {};
	}
	
}
class someDataServiceOneStub implements SomeDataService{

	@Override
	public int[] retriveAllData() {
		// TODO Auto-generated method stub
		return new int[] {1};
	}
	
}

public class SomeBusinessStubTest {
	
	@Test
	public void calculateSumUsingDataService_basic() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new someDataServiceStub());
		int actualvalue = business.calculateSumUsingDataService();
		int expectedvalue = 6;
		assertEquals(expectedvalue,actualvalue);
		
	}
	@Test
	public void calculateSumUsingDataService_empty() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new someDataServiceEmptyStub());
		int actualvalue = business.calculateSumUsingDataService();
		int expectedvalue = 0;
		assertEquals(expectedvalue,actualvalue);
		
	}
	@Test
	public void calculateSumUsingDataService_onevalue() {
		
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new someDataServiceOneStub());
		int actualvalue = business.calculateSumUsingDataService();
		int expectedvalue = 1;
		assertEquals(expectedvalue,actualvalue);
		
	}

}
