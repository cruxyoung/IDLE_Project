package com.idle.app.service;

import static org.junit.Assert.fail;

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
	public void testGetItemByName() {
		Item item = itemManager.getItemByName("testItem");
		assertEquals("testItem", item.getName());
	}

	@Test
	public void testAddItem() {

		itemManager.addItem(new Item());
		items = itemManager.getItems();

		assertEquals(2, items.size());

	}

	@Test
	public void testDeleteItem() {
		Item item = itemManager.getItemByName("testItem");
		
		itemManager.deleteItem(item.getId());
		assertEquals(0, itemManager.getItems().size());
	}

	@Test
	public void testUpdateItem() {
		Item item = itemManager.getItemByName("testItem");
		item.setName("newName");
		itemManager.updateItem(item);
		assertEquals("newName", itemManager.getItemById(item.getId()).getName());
	}

	@Test
	public void testGetItemById() {
		Item item = itemManager.getItemByName("testItem");
		Item newItem = itemManager.getItemById(item.getId());
		assertEquals(item.getName(), item.getName());
	}

	

	@After
	public void deleteAllItemsAttheEndofTest() {
		itemManager.deleteAllItems("Item");
		List<Item> res = itemManager.getItems();

	}

}
