package com.idle.app.web;

import java.util.Locale;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idle.app.service.CategoryManager;

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
