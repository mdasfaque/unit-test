package com.in28minutes.unittesting.unittesting.business;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import com.in28minutes.unittesting.unittesting.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

	@InjectMocks
	ItemBusinessService business;

	@Mock
	ItemRepository repository;

	@Test
	public void allItems_basic() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2,"Item2",10,100),new Item(3,"Item3",20,200)));
		List<Item> items = business.retrievAllItems();
		assertEquals(1000,items.get(0).getValue());
		assertEquals(4000,items.get(1).getValue());
	}

	
}