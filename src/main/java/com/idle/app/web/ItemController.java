package com.idle.app.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idle.app.domain.Item;
import com.idle.app.service.ItemManager;

@Controller
@RequestMapping(value="/item/**")
public class ItemController {
	
	@Resource(name="itemManager")
	private ItemManager itemManager;
	
//	create
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addItem(HttpServletRequest httpServletRequest) {
		
		Item item = new Item();
		item.setName(
				httpServletRequest.getParameter("name"));
		
		this.itemManager.addItem(item);
		
		return "ok";
	}
//	delete
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public String deleteItem(@PathVariable("id") Long id) {
		this.itemManager.deleteItem(id);
		return "delete ok";
		
	}
	
//read
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public String getItem(@PathVariable("id") Long id) {
		Map<String, String> res = new HashMap();
		Item itm = this.itemManager.getItemById(id);
//		res.put("id", new Long(itm.getId()).toString());
//		res.put("name", itm.getName());
		if(itm==null) System.out.println("get no itm");
		return itm.getName();
		
	}
	
	

}
