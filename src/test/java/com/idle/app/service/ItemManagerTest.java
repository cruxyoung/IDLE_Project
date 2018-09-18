package com.idle.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idle.app.domain.Item;

import junit.framework.TestCase;

public class ItemManagerTest extends TestCase {
	private List<Item> items;
	
	
	private ItemManager itemManager;

	protected void setUp() throws Exception{
		itemManager = new ItemManager();
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

