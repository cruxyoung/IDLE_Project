package com.idle.app.domain;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.idle.app.BaseTest;

public class ItemTest extends BaseTest {
	private Item item = new Item();

	@Test
	public void testSetAndGetItemId() {
		Long itemId = 1L;
		assertNull(item.getId());
		item.setId(itemId);
		assertEquals(itemId, item.getId());
	}

	@Test
	public void testSetAndGetName() {
		String name = "aDescription";
		assertNull(item.getName());
		item.setName(name);
		assertEquals(name, item.getName());
	}

	@Test
	public void testSetAndGetPhoto() {
		String photo = "photo";
		assertNull(item.getPhoto());
		item.setPhoto(photo);
		assertEquals(photo, item.getPhoto());
	}

	@Test
	public void testSetAndGetQuantity() {
		Long quantity = 6L;
		assertNull(item.getQuantity());
		item.setQuantity(quantity);
		assertEquals(quantity, item.getQuantity());
	}

	@Test
	public void testSetAndGetDescription() {
		String desc = "this is a Description";
		assertNull(item.getDescription());
		item.setDescription(desc);
		assertEquals(desc, item.getDescription());
	}

	@Test
	public void testSetAndGetVisitTime() {
		Long visitTime = 10L;
		assertNull(item.getVisit_time());
		item.setVisit_time(visitTime);
		assertEquals(visitTime, item.getVisit_time());
	}

	@Test
	public void testSetAndGetPrice() {
		Double price = 10.0;
		assertNull(item.getPrice());
		item.setPrice(price);
		assertEquals(price, item.getPrice());
	}

	@Test
	public void testSetAndGetPriority() {
		Integer priority = 1;
		assertNull(item.getPriority());
		item.setPriority(priority);
		assertEquals(priority, item.getPriority());
	}
	
	@Test
	public void testSetAndGetUser() {
		User user = new User();
		assertNull(item.getOwner());
		item.setOwner(user);;
		assertEquals(user, item.getOwner());
	}
	
	@Test
	public void testSetAndGetCategory() {
		Category category = new Category();
		assertNull(item.getCategory());
		item.setCategory(category);;
		assertEquals(category, item.getCategory());
	}
	
	@Test
	public void testSetAndGetCreateTime() {
		Date createTime = new Date();
		assertNull(item.getCreateTime());
		item.setCreateTime(createTime);
		assertEquals(createTime, item.getCreateTime());
	}

	@Test
	public void testSetAndGetLastEditTime() {
		Date lastEditTime = new Date();
		assertNull(item.getCreateTime());
		item.setLastEditTime(lastEditTime);
		assertEquals(lastEditTime, item.getLastEditTime());
	}
}
