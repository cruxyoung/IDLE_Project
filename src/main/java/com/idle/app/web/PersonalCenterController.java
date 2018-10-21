package com.idle.app.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idle.app.common.ServerResponse;
import com.idle.app.domain.User;
import com.idle.app.service.UserManager;

@Controller
@RequestMapping(value = "/personalcenter/")
public class PersonalCenterController {
	@Autowired
	private UserManager userManager;
	
	@RequestMapping(value = "personalinfo", method = RequestMethod.GET)
	public String personalInfo(Locale locale, Model model, HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();
		Long userId = (Long) session.getAttribute("userId");
		ServerResponse<User> re = this.userManager.getUserByUserId(userId);
		model.addAttribute("user",re.getData());
		
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
