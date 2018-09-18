package com.idle.app.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idle.app.domain.Item;
import com.idle.app.service.ItemManager;

@Controller
@RequestMapping(value="/item/**")
public class ItemController {
	
	@Resource(name="itemManager")
	private ItemManager itemManager;
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addProduct(HttpServletRequest httpServletRequest) {
		
		Item item = new Item();
		item.setName(
				httpServletRequest.getParameter("name"));
		
		this.itemManager.addItem(item);
		
		return "ok";
	}

}
