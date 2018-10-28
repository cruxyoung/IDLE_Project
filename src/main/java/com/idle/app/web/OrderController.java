package com.idle.app.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idle.app.domain.Address;
import com.idle.app.domain.Item;
import com.idle.app.domain.Order;
import com.idle.app.domain.User;
import com.idle.app.service.DatabaseAddressManager;
import com.idle.app.service.DatabaseUserManager;
import com.idle.app.service.ItemManager;
import com.idle.app.service.OrderManager;

@Controller
@RequestMapping(value = "/order/**")
public class OrderController {

	@Resource(name = "orderManager")
	private OrderManager orderManager;

	@Resource(name = "itemManager")
	private ItemManager itemManager;

	@Resource(name = "userManager")
	private DatabaseUserManager userManager;

	@Resource(name = "addressManager")
	private DatabaseAddressManager addressManager;

	@RequestMapping(value = "/createorder/{id}", method = RequestMethod.GET)
	public String item(@PathVariable("id") Long id, Model model, HttpSession session, HttpServletResponse response) throws Exception{
		Item item = itemManager.getItemById(id);
		Long userId = (Long)session.getAttribute("userId");
		if(userId==null) {
			response.sendRedirect("http://localhost:8080/app/user/login?error=notlogin");
			return null;
		}
		if(item.getOwner().getUserId().equals(userId)) {
			response.sendRedirect("http://localhost:8080/app/item/get/"+id.toString()+"?error=sameUser");
		}
		User currentUser = this.userManager.getUserByUserId(userId).getData();
		List<Address> addressList = addressManager.getAllAddressByUserId(userId).getData();
		model.addAttribute("addressList", addressList);
		model.addAttribute("item", item);
		model.addAttribute("user", currentUser);
		return "myOrder";
	}

	// create
	@RequestMapping(value = "/payNow", method = RequestMethod.POST)
	public String addOrder(HttpServletRequest request, HttpSession session, Model model, HttpServletResponse httpServletResponse) {
		String addressId = request.getParameter("address");
		User buyer = this.userManager.getUserByUserId((Long) session.getAttribute("userId")).getData();
		Item item = itemManager.getItemById(Long.parseLong(request.getParameter("itemId")));
		User seller = userManager.getUserByUserId(item.getOwner().getUserId()).getData();
		Address buyerAddress = addressManager.getAddressById(Long.parseLong(addressId)).getData();
		Address sellerAddress = addressManager.getAllAddressByUserId(seller.getUserId()).getData().get(0);
		Order order = new Order();
		order.setItem(item);
		order.setBuyer(buyer);
		order.setSeller(seller);
		order.setBuyerAddress(buyerAddress);
		order.setSellerAddress(sellerAddress);
		order.setOrderStatus(0L);
		order.setCreateTime(new Date());
		order.setLastEditTime(new Date());
		this.orderManager.addOrder(order);
		item.setQuantity(item.getQuantity() - 1);
		this.itemManager.updateItem(item);
//		return "redirect:/order/get/" + order.getId();
		try {
			httpServletResponse.sendRedirect("http://localhost:8080/app/personalcenter/mybought");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// delete
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String deleteItem(@PathVariable("orderId") Integer orderId) {
		this.orderManager.deleteOrder(orderId);
		return "delete ok";

	}

	// read
	@RequestMapping(value = "/get/{orderId}", method = RequestMethod.GET)
	public String getOrder(@PathVariable("orderId") Integer orderId, Model model) {
		Order order = this.orderManager.getOrderByOrderId(orderId);
		Address buyerAddress = addressManager.getAllAddressByUserId(order.getBuyer().getUserId()).getData().get(0);
		model.addAttribute("order", order);
		model.addAttribute("buyerAddress", buyerAddress);
		return "orderDetail";
	}

	@RequestMapping(value = "/orderConfirm/{orderId}", method = RequestMethod.GET)
	public String orderconfirm(@PathVariable("orderId") Integer orderId, Model model) {
		Order order = this.orderManager.getOrderByOrderId(orderId);
		Address buyerAddress = addressManager.getAllAddressByUserId(order.getBuyer().getUserId()).getData().get(0);
		model.addAttribute("order", order);
		model.addAttribute("buyerAddress", buyerAddress);
		return "orderConfirm";
	}

	@RequestMapping(value = "/orderConfirm", method = RequestMethod.POST)
	public String orderConfirm(Model model, HttpServletRequest request, HttpServletResponse httpServletResponse) {
		String orderId = request.getParameter("orderId");
		Order order = this.orderManager.getOrderByOrderId(Integer.parseInt(orderId));
		order.setOrderStatus(1L);
		order.setLastEditTime(new Date());
		this.orderManager.updateOrder(order);
		User buyer = order.getBuyer();
		buyer.setLastEditTime(new Date());
		buyer.setBalance(buyer.getBalance() - order.getItem().getPrice());
		userManager.updateUser(buyer);
		User seller = order.getSeller();
		seller.setLastEditTime(new Date());
		seller.setBalance(seller.getBalance() + order.getItem().getPrice());
		userManager.updateUser(seller);
//		return "redirect:/order/get/" + order.getId();
		
		try {
			httpServletResponse.sendRedirect("http://localhost:8080/app/personalcenter/mysold");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/orderRefund/{orderId}", method = RequestMethod.GET)
	public String refund(@PathVariable("orderId") Integer orderId, Model model) {
		model.addAttribute("order", this.orderManager.getOrderByOrderId(orderId));
		return "refundApply";
	}

	@RequestMapping(value = "/orderRefund", method = RequestMethod.POST)
	public String refund(HttpSession session, Model model, HttpServletRequest request) {
		String orderId = request.getParameter("orderId");
		String reason = request.getParameter("reason");
		Order order = this.orderManager.getOrderByOrderId(Integer.parseInt(orderId));
		order.setOrderStatus(2L);
		order.setRefundReason(reason);
		order.setLastEditTime(new Date());
		this.orderManager.updateOrder(order);
		return "redirect:/order/get/" + order.getId();
	}

	@RequestMapping(value = "/refundConfirm/{orderId}", method = RequestMethod.GET)
	public String refundConfirm(@PathVariable("orderId") Integer orderId, Model model) {
		model.addAttribute("order", this.orderManager.getOrderByOrderId(orderId));
		return "refundConfirm";
	}

	@RequestMapping(value = "/refundConfirm", method = RequestMethod.POST)
	public String refundConfirm(HttpSession session, Model model, HttpServletRequest request, HttpServletResponse httpServletResponse) {
		String orderId = request.getParameter("orderId");
		String operation = request.getParameter("operation");
		Order order = this.orderManager.getOrderByOrderId(Integer.parseInt(orderId));
		if ("agree".equals(operation)) {
			order.setOrderStatus(3L);
			User buyer = order.getBuyer();
			buyer.setLastEditTime(new Date());
			buyer.setBalance(buyer.getBalance() + order.getItem().getPrice());
			userManager.updateUser(buyer);
			User seller = order.getSeller();
			seller.setLastEditTime(new Date());
			seller.setBalance(seller.getBalance() - order.getItem().getPrice());
			userManager.updateUser(seller);
		} else {
			order.setOrderStatus(4L);
		}
		order.setLastEditTime(new Date());
		this.orderManager.updateOrder(order);
//		return "redirect:/order/get/" + order.getId();
		try {
			httpServletResponse.sendRedirect("http://localhost:8080/app/order/orderConfirm/"+orderId);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
