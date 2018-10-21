package com.idle.app.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idle.app.common.ServerResponse;
import com.idle.app.domain.User;
import com.idle.app.service.UserManager;

@Controller
@RequestMapping(value="/user/")
public class UserController {
	@Autowired
	private UserManager userManager;
	
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String username = httpServletRequest.getParameter("username");
		String password = httpServletRequest.getParameter("password");
		ServerResponse<User> response = userManager.login(username, password);

//		System.out.println(response.getStatus());
		if(response.getStatus() == 0) {
			User user = response.getData();
			HttpSession session = httpServletRequest.getSession();
			session.setAttribute("username", user.getUserName());
			session.setAttribute("userId", user.getUserId());
			return "main";
		}
			
		else {
			try {
				httpServletResponse.sendRedirect("login?error=yes");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "login";
		}
	}
	
	@RequestMapping(value = "signout", method = RequestMethod.GET)
	public String signout(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();
		session.removeAttribute("username");
		session.removeAttribute("userId");
		return "main";
	}
	
	@RequestMapping(value = "register.do", method = RequestMethod.POST)
	public String register(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String username = httpServletRequest.getParameter("username");
		String password = httpServletRequest.getParameter("password");
		String confirmPassword = httpServletRequest.getParameter("confirmpassword");
		String email = httpServletRequest.getParameter("email");
		String phone = httpServletRequest.getParameter("phone");
		if(!password.equals(confirmPassword)) {
			try {
				httpServletResponse.sendRedirect("register?error=wrongPassword");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		User user = new User();
		user.setBalance(0.0);
		user.setUserName(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		user.setCreateTime(new Date());
		user.setLastEditTime(new Date());
		
		ServerResponse<String> response = userManager.addUser(user);
		if(response.getStatus() == 0) {
			try {
				httpServletResponse.sendRedirect("login?SignUpresult="+response.getStatus());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				httpServletResponse.sendRedirect("register?error="+response.getMsg());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@RequestMapping(value = "modifyuserinfo.do", method = RequestMethod.POST)
	public String modiftUserInfo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String username = httpServletRequest.getParameter("username");
		String password = httpServletRequest.getParameter("password");
		String confirmPassword = httpServletRequest.getParameter("confirmpassword");
		String email = httpServletRequest.getParameter("email");
		String phone = httpServletRequest.getParameter("phone");
		
		
		if(!password.equals(confirmPassword)) {
			try {
				httpServletResponse.sendRedirect("personalinfo?error=wrongPassword");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else {
			User user = new User();
			
			user.setUserName(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
			user.setLastEditTime(new Date());
			
			ServerResponse<String> response = this.userManager.updateUser(user);
			try {
				httpServletResponse.sendRedirect("personalinfo?UpdateResult="+response.getMsg());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
