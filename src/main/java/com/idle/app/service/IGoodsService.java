package com.idle.app.service;

import java.util.List;

import com.idle.app.domain.Item;

public interface IGoodsService
{
	List<Item> findbySearch(String type, String name, String sort);
	List<Item> findBanner();

}
