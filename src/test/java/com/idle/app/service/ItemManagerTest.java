package com.idle.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.idle.app.BaseTest;
import com.idle.app.domain.Item;


public class ItemManagerTest extends BaseTest {
	private List<Item> items;
	
	@Resource(name="itemManager")
	private ItemManager itemManager;

	protected void setUp() throws Exception{
		Item item = new Item();
		items = new ArrayList<Item>();
		
		item.setName("testItem");
		itemManager.addItem(item);
		
	}
	@Test
	public void testGetItems() {
		List<Item> res = itemManager.getItems();
		for(Item it:res) {
			System.out.println(it.getName());
		}
		assertEquals(null,null);
	}
	
}

