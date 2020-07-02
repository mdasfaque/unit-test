package com.in28minutes.unittesting.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;

@Component
public class ItemBusinessService {

	@Autowired
	ItemRepository repository;
	
	public Item getHardCodedItem() {
		// TODO Auto-generated method stub
		return new Item(1,"ball",10,100);
	}
	
	public List<Item> retrievAllItems(){
		List<Item> items = repository.findAll();
		for(Item item:items) {
			item.setValue(item.getPrice()*item.getQuantity());
		}
		return items;
	}

}
