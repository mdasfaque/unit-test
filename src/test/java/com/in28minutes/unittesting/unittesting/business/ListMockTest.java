package com.in28minutes.unittesting.unittesting.business;

import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;

public class ListMockTest {
	List<String> mock =Mockito.mock(List.class);
	@Test
	public void size_basic() {
		
		when(mock.size()).thenReturn(5);
		assertEquals(5,mock.size());
	}
	
	@Test
	public void differentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5,mock.size());
		assertEquals(10,mock.size());
	}
	@Test
	public void returnWithParameter() {
		when(mock.get(0)).thenReturn("in28minutes");
		assertEquals("in28minutes",mock.get(0));
		assertEquals(null,mock.get(1));
		
	}
	
	@Test
	public void returnWithGenericParameter() {
		when(mock.get(anyInt())).thenReturn("in28minutes");
		assertEquals("in28minutes",mock.get(0));
		//assertEquals(null,mock.get(1)); failed
		assertEquals("in28minutes",mock.get(1));
		
	}
	@Test
	public void verification() {
		//to verify specific method is called with specific value
		//system under testing
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, never()).get(2);
		
	}
	
	@Test
	public void argumentCapture() {
		//to verify the argument 
		mock.add("in28minute");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		assertEquals("in28minute",captor.getValue());
	}
	@Test
	public void multipleArgumentCapture() {
		//to verify the multiple argument passed to a method
		mock.add("somestring1");
		mock.add("somestring2");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock,times(2)).add(captor.capture());
		List<String> allValues = captor.getAllValues();
		assertEquals("somestring1",allValues.get(0));
		assertEquals("somestring2",allValues.get(1));
	}

}
