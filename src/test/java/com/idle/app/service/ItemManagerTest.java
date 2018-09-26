package com.idle.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.idle.app.BaseTest;
import com.idle.app.domain.Item;

public class ItemManagerTest extends BaseTest {
	private List<Item> items;

	@Resource(name = "itemManager")
	private ItemManager itemManager;
	
	@Override
	protected void setUp() throws Exception {
		Item item = new Item();
		items = new ArrayList<Item>();

		item.setName("testItem");
		itemManager.addItem(item);
		Item item2  = new Item();
		item.setName("testItem2");
		itemManager.addItem(item2);

	}

	@Test
	public void testGetItems() {
		List<Item> res = itemManager.getItems();
		for(Item i:res) {
			System.out.println(i.toString());
			
		}
		
		assertEquals(2, res.size());
	}

	
	@Test
	public void deleteAllItemsAttheEndofTest() {
		itemManager.deleteAllItems("Item");
		List<Item> res = itemManager.getItems();
		assertEquals(0, res.size());

	}

	

}
