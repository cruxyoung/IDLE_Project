package com.idle.app.service;

import java.util.List;

import com.shop.web.entity.GoodsEntity;

public interface IGoodsService
{
	List<GoodsEntity> findbySearch(String type, String name, String sort);
	List<GoodsEntity> findBanner();

}
