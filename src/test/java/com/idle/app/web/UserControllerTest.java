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

import com.idle.app.service.UserManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/persistence-context.xml", "classpath:/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional

@WebAppConfiguration
public class UserControllerTest {

	MockMvc mockMvc;
	HashMap<String, Object> sessionattr = new HashMap<String, Object>();
	@Autowired
	protected WebApplicationContext wac;
	@Autowired
	UserManager userManager;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	@Ignore
	public void testUserLoginPost() throws Exception {
		MvcResult response = mockMvc.perform(post("/user/login.do").param("username", "1").param("password", "1")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	@Ignore
	public void testUserRegisterPost() throws Exception{
		MvcResult response = mockMvc.perform(post("/user/register.do")
				.param("username", "1").param("password", "1").param("confirmpassword", "1").param("email", "123@123.com").param("phone", "123321123321")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isFound()).andReturn();
	
	}
	
	@Test
	@Ignore
	public void testUserSignOutGet() throws Exception{
		MvcResult response = mockMvc.perform(get("/user/signout")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	@Ignore
	public void testModifyUserInfoPost() throws Exception{
		MvcResult response = mockMvc.perform(post("/user/modifyuserinfo.do")
				.param("username", "1").param("password", "1").param("confirmpassword", "1").param("email", "123@123.com").param("phone", "123321123321")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(status().isFound()).andReturn();
	
	}
}
