package com.idle.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.idle.app.BaseTest;
import com.idle.app.common.ServerResponse;
import com.idle.app.domain.Item;
import com.idle.app.domain.User;
import com.idle.app.domain.ViewRecord;

public class ViewRecordManagerTest extends BaseTest {
	@Resource(name = "itemManager")
	private ItemManager itemManager;

	@Resource(name = "userManager")
	UserManager userManager;

	@Autowired
	public ViewRecordManager viewRecordManager;

	@Test
	@Ignore
	public void testGetRecordsByUser() {
		User user = this.userManager.getUserByUserId(new Long(3)).getData();
		List<ViewRecord> records = viewRecordManager.getRecordsByUser(user).getData();
		for (ViewRecord res : records) {
			System.out.println(res.getId());
		}

		assertEquals(3, records.size());
	}

	@Test
	@Ignore
	public void testGetFavoriteRecordsByUser() {
		User user = this.userManager.getUserByUserId(1L).getData();
		List<ViewRecord> records = viewRecordManager.getFavoriteRecordsByUser(user).getData();
		for (ViewRecord res : records) {
			System.out.println(res.getId());
		}
		assertEquals(0, viewRecordManager.getFavoriteRecordsByUser(user).getStatus());

	}

	@Test
	@Ignore
	public void testgetViewRecordById() {
		Long viewRecordId = 1L;
		System.out.println(this.viewRecordManager.getViewRecordById(viewRecordId).getMsg());
	}

	@Test
	@Ignore
	public void testdeleteViewRecord() {
		Long viewRecordId = 1L;
		System.out.println(this.viewRecordManager.deleteViewRecord(viewRecordId).getMsg());
	}

	@Test
	@Ignore
	public void testdeleteFavoriteViewRecord() {
		Long viewRecordId = 9L;
		ServerResponse<String> re = this.viewRecordManager.deleteFavoriteRecord(viewRecordId);
		System.out.println(re.getMsg());
		assertEquals(0, re.getStatus());
	}

	@Test
	@Ignore
	public void testdeleteFavoriteRecord() {
		Long viewRecordId = 1L;
		System.out.println(this.viewRecordManager.deleteFavoriteRecord(viewRecordId).getMsg());
	}

	@Test
	@Ignore
	public void testAddRecord() {
		Item item = this.itemManager.getItemById(10L);
		User user = this.userManager.getUserByUserId(1L).getData();
		ServerResponse<String> re = this.viewRecordManager.addRecord(item, user);
		System.out.println(re.getMsg());
		assertEquals(0, re.getStatus());
	}

	@Test
	@Ignore
	public void testCheckRecord() {
		Item item = this.itemManager.getItemById(10L);
		User user = this.userManager.getUserByUserId(1L).getData();
		ServerResponse<Boolean> re = this.viewRecordManager.checkRecord(item, user);
		System.out.println(re.getMsg());
		assertEquals(0, re.getStatus());
	}

	@Test
	@Ignore
	public void testUpdateLastEditTime() {
		Item item = this.itemManager.getItemById(10L);
		User user = this.userManager.getUserByUserId(1L).getData();
		ServerResponse<String> re = this.viewRecordManager.updateLastEditTime(item, user);
		System.out.println(re.getMsg());
		assertEquals(0, re.getStatus());
	}

	@Test
	@Ignore
	public void testChangeFavStatus() {
		Item item = this.itemManager.getItemById(10L);
		User user = this.userManager.getUserByUserId(1L).getData();
		ServerResponse<String> re = this.viewRecordManager.changeFavStatus(item, user);
		System.out.println(re.getMsg());
		assertEquals(0, re.getStatus());
	}
	
	@Test
	@Ignore
	public void testGetRecord() {
		Item item = this.itemManager.getItemById(10L);
		User user = this.userManager.getUserByUserId(1L).getData();
		ServerResponse<ViewRecord> re = this.viewRecordManager.getRecord(item, user);
		System.out.println(re.getMsg());
		assertEquals(0, re.getStatus());
	}
}
