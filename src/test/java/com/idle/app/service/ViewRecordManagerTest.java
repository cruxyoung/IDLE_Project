package com.idle.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.idle.app.BaseTest;
import com.idle.app.domain.User;
import com.idle.app.domain.ViewRecord;


public class ViewRecordManagerTest extends BaseTest {
	@Resource(name = "itemManager")
	private ItemManager itemManager;

	@Resource(name="userManager")
	UserManager userManager;
	@Autowired
	public ViewRecordManager viewRecordManager;
	@Test
	public void testGetRecordsByUser() {
		User user = this.userManager.getUserByUserId(new Long(3)).getData();
		List<ViewRecord> records = viewRecordManager.getRecordsByUser(user).getData();
		for(ViewRecord res:records) {
			System.out.println(res.getId());
		}
		
		assertEquals(3, records.size());
	}
}
