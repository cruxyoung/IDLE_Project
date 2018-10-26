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
public class PersonalCenterControllerTest {
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
	public void testPersonalInfoGet() throws Exception{
		sessionattr.put("userId", 1L);
		MvcResult response = mockMvc.perform(get("/personalcenter/personalinfo").sessionAttrs(sessionattr)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	@Ignore
	public void testAddressGet() throws Exception{
		sessionattr.put("userId", 1L);
		MvcResult response = mockMvc.perform(get("/personalcenter/address").sessionAttrs(sessionattr)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	@Ignore
	public void testViewHistoryGet() throws Exception{
		sessionattr.put("userId", 1L);
		MvcResult response = mockMvc.perform(get("/personalcenter/viewhistory").sessionAttrs(sessionattr)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	@Ignore
	public void testMyFavoriteGet() throws Exception{
		sessionattr.put("userId", 1L);
		MvcResult response = mockMvc.perform(get("/personalcenter/myfavorite").sessionAttrs(sessionattr)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	@Ignore
	public void testDeleteMyFavoriteGet() throws Exception{
		sessionattr.put("userId", 1L);
		MvcResult response = mockMvc.perform(get("/personalcenter/myfavorite/delete/8").sessionAttrs(sessionattr)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isFound()).andReturn();
	}
	
	@Test
	@Ignore
	public void testDeleteViewHistoryGet() throws Exception{
		sessionattr.put("userId", 1L);
		MvcResult response = mockMvc.perform(get("/personalcenter/viewhistory/delete/8").sessionAttrs(sessionattr)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isFound()).andReturn();
	}
	
	@Test
	@Ignore
	public void testMypublishedGet() throws Exception{
		sessionattr.put("userId", 1L);
		MvcResult response = mockMvc.perform(get("/personalcenter/mypublished").sessionAttrs(sessionattr)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	@Ignore
	public void testMyboughtGet() throws Exception{
		sessionattr.put("userId", 1L);
		MvcResult response = mockMvc.perform(get("/personalcenter/mybought").sessionAttrs(sessionattr)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	@Ignore
	public void testMysoldGet() throws Exception{
		sessionattr.put("userId", 1L);
		MvcResult response = mockMvc.perform(get("/personalcenter/mysold").sessionAttrs(sessionattr)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	@Ignore
	public void testModifyUserInfoPost() throws Exception{
		sessionattr.put("userId", 1L);
		MvcResult response = mockMvc.perform(post("/personalcenter/modifyuserinfo.do").sessionAttrs(sessionattr)
				.param("username", "1").param("password", "1").param("confirmpassword", "1").param("email", "123@123.com").param("phone", "123321123321")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isFound()).andReturn();
	
	}
}
