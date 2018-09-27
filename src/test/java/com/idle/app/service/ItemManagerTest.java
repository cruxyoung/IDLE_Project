package com.idle.app.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.*;

import com.idle.app.BaseTest;
import com.idle.app.domain.Item;

public class ItemManagerTest extends BaseTest {
	private List<Item> items;

	@Resource(name = "itemManager")
	private ItemManager itemManager;
	
	@Before
	public void setUp() throws Exception {
		Item item = new Item();

		item.setName("testItem");
		item.setCreateTime(new Date());
		item.setDescription("fak");
		item.setOwner(null);
		item.setPrice(10.0);
		item.setPriority(null);
		item.setQuantity(10);
		item.setVisit_time(new Date());
		item.setLastEditTime(new Date());
		this.itemManager.addItem(item);
	}

	@Test
	public void testGetItems() {
		

		items = itemManager.getItems();
		System.out.println("fadfdafadfa");
		assertEquals(1, items.size());
				

	}

	
	@Test
	public void deleteAllItemsAttheEndofTest() {
		itemManager.deleteAllItems("Item");
		List<Item> res = itemManager.getItems();
		assertEquals(0, res.size());

	}

	

}
