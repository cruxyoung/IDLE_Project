package com.idle.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.idle.app.domain.Item;

import junit.framework.TestCase;


public class ItemManagerTest extends TestCase {
	private List<Item> items;
	
	@Resource(name="itemManager")
	private ItemManager itemManager;

	protected void setUp() throws Exception{
		Item item = new Item();
		items = new ArrayList<Item>();
		
		item.setName("testItem");
		itemManager.addItem(item);
		
	}
	
	public void testGetItems() {
		List<Item> res = itemManager.getItems();
		for(Item it:res) {
			System.out.println(it.getName());
		}
		assertEquals(null, null);
		
	}
	
}

