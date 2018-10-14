package com.idle.app.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		
		item.setName(httpServletRequest.getParameter("name"));
		item.setQuantity(Long.valueOf(httpServletRequest.getParameter("quantity")));
		item.setDescription(httpServletRequest.getParameter("description"));
		item.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
		item.setCreateTime(new Date());
		item.setLastEditTime(new Date());

		if(item.getName().length()==0) item.setName("default"+ new Date().toString());
		
		
		
		this.itemManager.addItem(item);
//		redirect to main page(to be implemented)
		return "redirect:/";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddItem() {
		return "addItem";
	}
	
//	delete
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public String deleteItem(@PathVariable("id") Long id) {
		this.itemManager.deleteItem(id);
		return "delete ok";
		
	}
	
//read
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public String getItem(@PathVariable("id") Long id,Model model) {
		Map<String, String> res = new HashMap();
		Item item = this.itemManager.getItemById(id);
//		res.put("id", new Long(itm.getId()).toString());
//		res.put("name", itm.getName());
		model.addAttribute("item",item);
		if(item==null) System.out.println("get no itm");
		return "itemDisplay";
		
	}
	
	

	
	
	
	

}
