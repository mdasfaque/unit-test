package com.in28minutes.unittesting.unittesting.business;

import org.springframework.stereotype.Component;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

@Component
public class SomeBusinessImpl {

	private SomeDataService someDataService;
	
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {
		int sum=0;
		for(int value: data) {
			sum +=value;
		}
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		
		int[] data= someDataService.retriveAllData();
		int sum=0;
		for(int value: data) {
			sum +=value;
		}
		return sum;
	}
}
