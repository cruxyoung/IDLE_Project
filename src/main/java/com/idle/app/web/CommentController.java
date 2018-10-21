//package com.idle.app.web;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.idle.app.domain.Item;
//import com.idle.app.domain.User;
//import com.idle.app.service.CommentManager;
//import com.idle.app.service.ItemManager;
//import com.idle.app.service.UserManager;
//
//@Controller
//@RequestMapping(value = "/comment/**")
//public class CommentController {
//	@Resource(name = "itemManager")
//	private ItemManager itemManager;
//	
//	@Autowired
//	private UserManager userManager;
//	
//	@Autowired
//	private CommentManager commentManager;
//	
//	@RequestMapping(value="/add", method= RequestMethod.POST)
//	public String addComment(HttpServletRequest httpServletRequest,HttpSession session) {
//		Long itemId = ()session.getAttribute("itemId");
//		Item item = itemManager.getItemById(itemId);
//		String content = httpServletRequest.getParameter("content");
//		User user = userManager.getUserByUserId((Long)session.getAttribute("userId")).getData();
//		commentManager.addComments(content, item, user);
//		return "redirect:/item/get"+itemId.toString();
//		
//	}
//
//}
