package com.idle.app.web;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/personalcenter/")
public class PersonalCenterController {
	
	@RequestMapping(value = "personalinfo", method = RequestMethod.GET)
	public String personalInfo(Locale locale, Model model) {
		return "personalinfo";
	}  
	
	@RequestMapping(value = "address", method = RequestMethod.GET)
	public String address(Locale locale, Model model) {
		return "address";
	} 
	
	@RequestMapping(value = "viewhistory", method = RequestMethod.GET)
	public String viewHistory(Locale locale, Model model) {
		return "viewhistory";
	}  
	
	@RequestMapping(value = "myfavorite", method = RequestMethod.GET)
	public String myFavorite(Locale locale, Model model) {
		return "myfavorite";
	}  
	
	@RequestMapping(value = "mypublished", method = RequestMethod.GET)
	public String myPublished(Locale locale, Model model) {
		return "mypublished";
	}  
}
