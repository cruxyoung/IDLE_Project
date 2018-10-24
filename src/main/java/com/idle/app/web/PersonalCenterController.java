package com.idle.app.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idle.app.common.ServerResponse;
import com.idle.app.domain.Address;
import com.idle.app.domain.Item;
import com.idle.app.domain.User;
import com.idle.app.domain.ViewRecord;
import com.idle.app.service.AddressManager;
import com.idle.app.service.ItemManager;
import com.idle.app.service.UserManager;
import com.idle.app.service.ViewRecordManager;

@Controller
@RequestMapping(value = "/personalcenter/")
public class PersonalCenterController {
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private AddressManager addressManager;
	
	@Autowired
	private ItemManager itemManager;
	
	@Autowired
	private ViewRecordManager viewRecordManager;
	
	@RequestMapping(value = "personalinfo", method = RequestMethod.GET)
	public String personalInfo(Locale locale, Model model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		HttpSession session = httpServletRequest.getSession();
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			try {
				httpServletResponse.sendRedirect("http://localhost:8080/app/user/login?error=notlogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		ServerResponse<User> re = this.userManager.getUserByUserId(userId);
		model.addAttribute("user",re.getData());
		
		return "personalinfo";
	}  
	
	@RequestMapping(value = "address", method = RequestMethod.GET)
	public String address(Locale locale, Model model,  HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		HttpSession session = httpServletRequest.getSession();
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			try {
				httpServletResponse.sendRedirect("http://localhost:8080/app/user/login?error=notlogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		ServerResponse<List<Address>> re = this.addressManager.getAllAddressByUserId(userId);
		model.addAttribute("addresslist",re.getData());
		return "address";
	} 
	
	@RequestMapping(value = "viewhistory", method = RequestMethod.GET)
	public String viewHistory(Locale locale, Model model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		HttpSession session = httpServletRequest.getSession();
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			try {
				httpServletResponse.sendRedirect("http://localhost:8080/app/user/login?error=notlogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		User user = this.userManager.getUserByUserId(userId).getData();
		ServerResponse<List<ViewRecord>> re = this.viewRecordManager.getRecordsByUser(user);
		model.addAttribute("viewRecordlist", re.getData());
//		System.out.println(re.getMsg());
		return "viewhistory";
	}  
	
	@RequestMapping(value = "myfavorite", method = RequestMethod.GET)
	public String myFavorite(Locale locale, Model model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		HttpSession session = httpServletRequest.getSession();
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			try {
				httpServletResponse.sendRedirect("http://localhost:8080/app/user/login?error=notlogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		User user = this.userManager.getUserByUserId(userId).getData();
		ServerResponse<List<ViewRecord>> re = this.viewRecordManager.getFavoriteRecordsByUser(user);
		model.addAttribute("favoriteRecordlist", re.getData());
		System.out.println(re.getMsg());
		return "myfavorite";
	}  
	
	@RequestMapping(value = "myfavorite/delete/{id}", method = RequestMethod.GET)
	public void deleteMyFavorite(@PathVariable("id") Long viewRecordId, HttpServletResponse response) {
		ServerResponse<String> re = this.viewRecordManager.deleteFavoriteRecord(viewRecordId);
		try {
			response.sendRedirect("http://localhost:8080/app/personalcenter/myfavorite?result="+re.getMsg());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "viewhistory/delete/{id}", method = RequestMethod.GET)
	public void deleteViewhistory(@PathVariable("id") Long viewRecordId, HttpServletResponse response) {
		ServerResponse<String> re = this.viewRecordManager.deleteViewRecord(viewRecordId);
		try {
			response.sendRedirect("http://localhost:8080/app/personalcenter/viewhistory?result="+re.getMsg());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "mypublished", method = RequestMethod.GET)
	public String myPublished(Locale locale, Model model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		HttpSession session = httpServletRequest.getSession();
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			try {
				httpServletResponse.sendRedirect("http://localhost:8080/app/user/login?error=notlogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		User user = this.userManager.getUserByUserId(userId).getData();
		ServerResponse<List<Item>> re = this.itemManager.getItemsByUser(user);
		model.addAttribute("itemlist", re.getData());
//		System.out.println(re.getMsg());
		return "mypublished";
	}
	
	@RequestMapping(value = "mybought", method = RequestMethod.GET)
	public String myBought(Locale locale, Model model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		HttpSession session = httpServletRequest.getSession();
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			try {
				httpServletResponse.sendRedirect("http://localhost:8080/app/user/login?error=notlogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
//		User user = this.userManager.getUserByUserId(userId).getData();
//		ServerResponse<List<Item>> re = this.itemManager.getItemsByUser(user);
//		model.addAttribute("itemlist", re.getData());
//		System.out.println(re.getMsg());
		return "mybought";
	}
	
	@RequestMapping(value = "mysold", method = RequestMethod.GET)
	public String mySold(Locale locale, Model model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		HttpSession session = httpServletRequest.getSession();
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			try {
				httpServletResponse.sendRedirect("http://localhost:8080/app/user/login?error=notlogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
//		User user = this.userManager.getUserByUserId(userId).getData();
//		ServerResponse<List<Item>> re = this.itemManager.getItemsByUser(user);
//		model.addAttribute("itemlist", re.getData());
//		System.out.println(re.getMsg());
		return "mysold";
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
			HttpSession session = httpServletRequest.getSession();
			Long userId = (Long) session.getAttribute("userId");
			
			User user = new User();
			user.setUserId(userId);
			user.setUserName(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
			user.setLastEditTime(new Date());
			
			ServerResponse<String> response = this.userManager.updateUser(user);
			try {
				httpServletResponse.sendRedirect("personalinfo?updateresult="+response.getMsg());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@RequestMapping(value = "topup.do", method = RequestMethod.POST)
	public void topup(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String balance = httpServletRequest.getParameter("balance");
		if(!isNumeric(balance)) {
			try {
				httpServletResponse.sendRedirect("personalinfo?error=balanceWrong");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		HttpSession session = httpServletRequest.getSession();
		Long userId = (Long) session.getAttribute("userId");
		User user = new User();
		user.setUserId(userId);
		user.setBalance(Double.valueOf(balance));
		ServerResponse<String> response = this.userManager.updateBalance(user);
		try {
			httpServletResponse.sendRedirect("personalinfo?updateresult="+response.getMsg());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean isNumeric(String str){
		//最多两位小数的正数
		Pattern pattern = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
		return pattern.matcher(str).matches();
		}
	
}
