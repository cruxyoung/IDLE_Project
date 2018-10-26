package com.idle.app.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/persistence-context.xml", "classpath:/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional

@WebAppConfiguration
public class MainControllerTest {

	MockMvc mockMvc;
	HashMap<String, Object> sessionattr = new HashMap<String, Object>();
	@Autowired
	protected WebApplicationContext wac;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testUserLoginPageGet() throws Exception {
		String response = mockMvc.perform(get("/user/login")).andExpect(status().isOk()).andDo(print()).andReturn().getResponse()
				.getContentAsString();
	}
	
	@Test
	public void testRegisterPageGet() throws Exception {
		String response = mockMvc.perform(get("/user/register")).andExpect(status().isOk()).andDo(print()).andReturn().getResponse()
				.getContentAsString();
	}
	
	@Test
	public void testMainPageGet() throws Exception {
		String response = mockMvc.perform(get("/")).andExpect(status().isOk()).andDo(print()).andReturn().getResponse()
				.getContentAsString();
	}
}
