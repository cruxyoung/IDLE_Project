package com.idle.app.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/persistence-context.xml", "classpath:/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration
public class ControllerTest {
	 MockMvc mockMvc;

	@Autowired
    protected WebApplicationContext wac;
	@Before
	public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); 
    }
//	test main page
	@Test
	public void testMainPageController() throws Exception {
		String response = mockMvc.perform(
				get("/"))
				.andExpect(status()
						.isOk())
				.andDo(print())
				.andReturn()
				.getResponse()
				.getContentAsString();
//		System.out.println(response);
	}
	
	
	
}
