package com.idle.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idle.app.service.IGoodsService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
public class HomeController
{

	@Autowired
	IGoodsService iGoodsService;
	// Ö÷Ò³
	@RequestMapping("/home")
	public String index(Model model)
	{
		model.addAttribute("banners",
				JSONArray.fromObject(iGoodsService.findBanner()));
		model.addAttribute("goods", JSONArray.fromObject(
				iGoodsService.findbySearch(null, "", "createtime")));
		return "home";
	}

	// Ö÷Ò³ËÑË÷=== ËÑË÷¹¦ÄÜ+·¶³ëÑ¡Ôñ +ÅÅÐòº¯Êý
	@RequestMapping("/home/search")
	public @ResponseBody Object search(String type, String name, String sort)
	{
		System.out.println(" search " + type + "||" + name + "||" + sort);
		if ("New".equals(sort))
		{
			sort = "createtime";
		}
		JSONObject json = new JSONObject();
		json.accumulate("rst", JSONArray.fromObject(
				iGoodsService.findbySearch(type, name, sort.toLowerCase())));
		return json;
	}
}
