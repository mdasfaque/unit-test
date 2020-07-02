package com.in28minutes.unittesting.unittesting.Controller;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value=HelloWorldController.class )
public class HelloWorldControllerTest {
	
	
	@Autowired
	private MockMvc mockmvc;
	
	@Test
	public void helloWorld_basic() throws Exception {
		RequestBuilder rq = MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockmvc.perform(rq)
				.andExpect(status().isOk())
				.andExpect(content().string("hello World"))
				.andReturn();
		//assertEquals("hello World",result.getResponse().getContentAsString());
		
	}

}
