package com.in28minutes.unittesting.unittesting.Controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(value=ItemController.class )
public class ItemControllerTest {
	
	
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	public void dummyItem_basic() throws Exception {
		RequestBuilder rq = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockmvc.perform(rq)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"ball\",\"price\":10,\"quantity\":100}"))
				//.andExpect(content().json("{\"id\": 1,\"name\":\"ball\",\"price\":10,\"quantity\":100}")) --pass
				//.andExpect(content().json("{\"id\": 1,\"name\":\"ball\",\"price\":10}"))--pass 
				.andReturn();
		//assertEquals("hello World",result.getResponse().getContentAsString());
		
	}
	
	@Test
	public void itemFromBussinessService_basic() throws Exception {
		when(businessService.getHardCodedItem()).thenReturn(
				new Item(2,"Item2",10,100));
		RequestBuilder rq = MockMvcRequestBuilders.get("/item-from-bussiness-service").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockmvc.perform(rq)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":2,\"name\":\"Item2\",\"price\":10,\"quantity\":100}")) 
				.andReturn();
		
	}
	
	@Test
	public void retrievAllItems_basic() throws Exception {
		when(businessService.retrievAllItems()).thenReturn(
				Arrays.asList(new Item(2,"Item2",10,100),new Item(3,"Item3",20,200))
				);
		RequestBuilder rq = MockMvcRequestBuilders.get("/all-items-from-database").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockmvc.perform(rq)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":2,\"name\":\"Item2\",\"price\":10,\"quantity\":100},{\"id\":3,\"name\":\"Item3\",\"price\":20,\"quantity\":200}]")) 
				.andReturn();
		
	}

}
