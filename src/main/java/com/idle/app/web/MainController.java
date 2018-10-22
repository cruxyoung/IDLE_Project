package com.idle.app.web;

import java.io.IOException;
import java.util.Locale;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.idle.app.domain.Category;
import com.idle.app.service.CategoryManager;
import com.idle.app.service.ItemManager;
@Controller
public class MainController {
//	initialize category data
	@Autowired
	public CategoryManager categoryManager;
	
	

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		

		return "main";
	}  
	
	
	@RequestMapping(value = "user/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {

		

		return "login";
	}  
	
	@RequestMapping(value = "user/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model) {

		

		return "register";
	} 
	
}
