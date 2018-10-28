package com.idle.app.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idle.app.domain.Item;
import com.idle.app.service.GoodsServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
public class HomeController
{

	@Autowired
	GoodsServiceImpl GoodsServiceImpl;
	// Ö÷Ò³
	@RequestMapping("/home")
	public String index(Model model)
	{
		model.addAttribute("banners",
				JSONArray.fromObject(GoodsServiceImpl.findBanner()));
		model.addAttribute("goods", JSONArray.fromObject(
				GoodsServiceImpl.findbySearch(null, "", "createTime")));
		return "home";
	}
	
	
	@RequestMapping("/homeSearch")
	public String homeSearch(HttpServletResponse response,Model model
			,@RequestParam(value="sort") String sort
			,@RequestParam(value="name") String name
			,@RequestParam(value="type") String type ) throws Exception {
		
		if ("New".equals(sort))
		{
			sort = "createTime";
		}else if("Price".equals(sort)) {
			sort="price";
		}else {
			sort="quantity";
		}
		System.out.println(" search " + type + "||" + name + "||" + sort);
		List<Item> res = GoodsServiceImpl.findbySearch(type, name, sort);
		model.addAttribute("banners",
				JSONArray.fromObject(GoodsServiceImpl.findBanner()));
		model.addAttribute("goods", JSONArray.fromObject(
				res));
		System.out.println(res.size());
		if(res.isEmpty()) {
			
			 response.sendRedirect("http://localhost:8080/app/home"+"?error=noSearchResult");
				return null;
		}else {
			return "home";
		}
			
		
	}

	// Ö÷Ò³ËÑË÷=== ËÑË÷¹¦ÄÜ+·¶³ëÑ¡Ôñ +ÅÅÐòº¯Êý
	@RequestMapping(value="/home/search", produces = "application/json")
	public  @ResponseBody Object search(String type, String name, String sort)
	{
		System.out.println(" search " + type + "||" + name + "||" + sort);
		if ("New".equals(sort))
		{
			sort = "createTime";
		}else if("Price".equals(sort)) {
			sort="price";
		}else {
			sort="quantity";
		}
		JSONObject json = new JSONObject();
		json.accumulate("rst", JSONArray.fromObject(
				GoodsServiceImpl.findbySearch(type, name, sort)).toString());
		System.out.println(json.toString());
		return json;
	}
}
