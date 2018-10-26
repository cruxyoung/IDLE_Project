package com.idle.app.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/persistence-context.xml", "classpath:/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional

@WebAppConfiguration
public class AddressControllerTest {

	MockMvc mockMvc;
	HashMap<String, Object> sessionattr = new HashMap<String, Object>();
	@Autowired
	protected WebApplicationContext wac;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	@Ignore
	public void testAddressDetailGet() throws Exception{
		sessionattr.put("userId", 1L);
		MvcResult response = mockMvc.perform(get("/personalcenter/address/addressdetail/1").sessionAttrs(sessionattr)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	@Ignore
	public void testDeleteAddressGet() throws Exception{
		sessionattr.put("userId", 1L);
		MvcResult response = mockMvc.perform(get("/personalcenter/address/delete/1").sessionAttrs(sessionattr)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isFound()).andReturn();
	}
	
	@Test
	@Ignore
	public void testModifyAddressPost() throws Exception{
		sessionattr.put("userId", 1L);
		MvcResult response = mockMvc.perform(post("/personalcenter/address/addressdetail/modify/1").sessionAttrs(sessionattr)
				.param("recivername", "jjack").param("receiverphone", "1234352").param("address", "newAddressss")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isFound()).andReturn();
	}
	
	@Test
	@Ignore
	public void testAddAddressPageGet() throws Exception{
		sessionattr.put("userId", 1L);
		MvcResult response = mockMvc.perform(get("/personalcenter/address/addaddress").sessionAttrs(sessionattr)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	@Ignore
	public void testAddAddressPost() throws Exception{
		sessionattr.put("userId", 1L);
		MvcResult response = mockMvc.perform(post("/personalcenter/address/add").sessionAttrs(sessionattr)
				.param("recivername", "newjack").param("receiverphone", "1221134352").param("address", "newnewAddressss")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isFound()).andReturn();
	}
}
