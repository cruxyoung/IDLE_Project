package com.idle.app.domain;

import java.util.Date;

import org.junit.Test;

import com.idle.app.BaseTest;

public class ViewRecordTest extends BaseTest {

	private ViewRecord viewRecord = new ViewRecord();
	
	@Test
	public void testSetAndGetViewRecordId() {
		Long viewRecordId = 5L;
		assertNull(viewRecord.getId());
		viewRecord.setId(viewRecordId);
		assertEquals(viewRecordId, viewRecord.getId());

	}
	
	@Test
	public void testSetAndGetUser() {
		User user = new User();
		assertNull(viewRecord.getUser());
		viewRecord.setUser(user);;
		assertEquals(user, viewRecord.getUser());
	}
	
	@Test
	public void testSetAndGetItem() {
		Item item = new Item();
		assertNull(viewRecord.getItem());
		viewRecord.setItem(item);
		assertEquals(item, viewRecord.getItem());
	}
	
	@Test
	public void testSetAndGetStatus() {
		Long status = 0L;
		assertNull(viewRecord.getStatus());
		viewRecord.setStatus(status);
		assertEquals(status, viewRecord.getStatus());

	}
	
	@Test
	public void testSetAndGetCreateTime() {
		Date createTime = new Date();
		assertNull(viewRecord.getCreateTime());
		viewRecord.setCreateTime(createTime);
		assertEquals(createTime, viewRecord.getCreateTime());
	}

	@Test
	public void testSetAndGetLastEditTime() {
		Date lastEditTime = new Date();
		assertNull(viewRecord.getCreateTime());
		viewRecord.setLastEditTime(lastEditTime);
		assertEquals(lastEditTime, viewRecord.getLastEditTime());
	}
	
}
