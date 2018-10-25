package com.idle.app.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.idle.app.service.UserManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/persistence-context.xml", "classpath:/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@WebAppConfiguration
public class ControllerTest {
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

	// test main page
	@Test
	public void testMainPageController() throws Exception {
		String response = mockMvc.perform(get("/")).andExpect(status().isOk()).andDo(print()).andReturn().getResponse()
				.getContentAsString();
	}

	@Test
	public void testAddItemController() throws Exception {
		sessionattr.put("userId", new Long(1));
		String response = mockMvc.perform(get("/item/add").sessionAttrs(sessionattr)).andExpect(status().isOk())
				.andDo(print()).andReturn().getResponse().getContentAsString();
	}

	@Test
	public void testAddItemControllerWithOutSession() throws Exception {
		String response = mockMvc.perform(get("/item/add"))
				.andExpect(redirectedUrl("http://localhost:8080/app/user/login?error=notlogin")).andDo(print())
				.andReturn().getResponse().getContentAsString();
	}

	@Test
	public void testDisplayItemPageWithSession() throws Exception {
		sessionattr.put("userId", new Long(1));
		String response = mockMvc.perform(get("/item/get/1").sessionAttrs(sessionattr)).andExpect(status().isOk())
				.andDo(print()).andReturn().getResponse().getContentAsString();
	}

	@Test
	public void testAddItemSuccess() throws Exception{
		MvcResult response = mockMvc
				.perform(post("/item/add")
						.param("category", "Antiques")
						.param("name","testItem")
						.param("quantity", "10")
						.param("description", "this is a test item do whatever you want")
						.contentType(MediaType.MULTIPART_FORM_DATA)
						).andExpect(status().isOk())
				.andReturn();
	}
	
	@Test
	public void testUserLoginPageGet() throws Exception {
		String response = mockMvc.perform(get("/user/login")).andExpect(status().isOk()).andDo(print()).andReturn().getResponse()
				.getContentAsString();
	}

	
	
	@Test
	public void testUserLoginPost()   throws Exception {
		MvcResult response = mockMvc
				.perform(post("/user/login.do")
						.param("username", "a")
						.param("password","a")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED))
						.andExpect(status().isOk())
				.andReturn();
	}
	


}
