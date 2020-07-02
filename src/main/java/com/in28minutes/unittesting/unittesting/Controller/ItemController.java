package com.in28minutes.unittesting.unittesting.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	private ItemBusinessService businessService;

	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1,"ball",10,100);
	}
	
	@GetMapping("/item-from-bussiness-service")
	public Item itemFromBussinessService() {
		return businessService.getHardCodedItem();
	}
	
	@GetMapping("/all-items-from-database")
	public List<Item> itemsFromDatabase(){
		return businessService.retrievAllItems();
	}
}
