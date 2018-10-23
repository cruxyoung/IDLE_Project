package com.idle.app.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.idle.app.common.ServerResponse;
import com.idle.app.domain.Address;
import com.idle.app.domain.User;
import com.idle.app.service.AddressManager;
import com.idle.app.service.UserManager;

@Controller
@RequestMapping(value = "/personalcenter/address")
public class AddressController {
	@Autowired
	private AddressManager addressManager;
	
	@Autowired
	private UserManager userManager;

	@RequestMapping(value = "/addressdetail/{id}")
	public String viewAddress(@PathVariable("id") Long addressId, Model model, HttpServletRequest httpServletRequest) {

		//save address id to session while it is not necessary
//		HttpSession session = httpServletRequest.getSession();
//		session.setAttribute("addressId", addressId);
		ServerResponse<Address> re = this.addressManager.getAddressById(addressId);
		model.addAttribute("address", re.getData());
		System.out.println(re.getMsg());
		return "addressDetail";
	}

	@RequestMapping(value = "/delete/{id}")
	public void deleteAddress(@PathVariable("id") Long addressId, HttpServletResponse httpServletResponse) {
		ServerResponse<String> re = this.addressManager.deleteAddress(addressId);
		try {
			httpServletResponse.sendRedirect("http://localhost:8080/app/personalcenter/address?updateresult="+re.getMsg());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/addressdetail/modify/{id}")
	public void modifyAddress(@PathVariable("id") Long addressId, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String receiverName = httpServletRequest.getParameter("recivername");
		String receiverPhone = httpServletRequest.getParameter("receiverphone");
		String address = httpServletRequest.getParameter("address");
		Address newAddress = new Address();
		newAddress.setReceiverName(receiverName);
		newAddress.setReceiverPhone(receiverPhone);
		newAddress.setAddress(address);
		
		//use session while it is not necessary
//		HttpSession session = httpServletRequest.getSession();
//		Long addressId = (Long) session.getAttribute("addressId");
		newAddress.setAddressId(addressId);
		
		ServerResponse<String> re = this.addressManager.updateAddress(newAddress);
		try {
			httpServletResponse.sendRedirect("http://localhost:8080/app/personalcenter/address?updateresult="+re.getMsg());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/addaddress")
	public String add(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		return "addAddress";
	}
	
	
	@RequestMapping(value = "/add")
	public void addAddress(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String receiverName = httpServletRequest.getParameter("recivername");
		String receiverPhone = httpServletRequest.getParameter("receiverphone");
		String address = httpServletRequest.getParameter("address");
		Address newAddress = new Address();
		newAddress.setReceiverName(receiverName);
		newAddress.setReceiverPhone(receiverPhone);
		newAddress.setAddress(address);
		newAddress.setCreateTime(new Date());
		newAddress.setLastEditTime(new Date());
		
		HttpSession session = httpServletRequest.getSession();
		Long userId = (Long) session.getAttribute("userId");
		User user = this.userManager.getUserByUserId(userId).getData();
		newAddress.setUser(user);
		
		ServerResponse<String> re = this.addressManager.addAddress(newAddress);
		try {
			httpServletResponse.sendRedirect("http://localhost:8080/app/personalcenter/address?updateresult="+re.getMsg());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
