package com.idle.app.service;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.idle.app.BaseTest;
import com.idle.app.domain.User;

public class DatabaseUserManagerTest extends BaseTest{
	
		@Resource(name="userManager")
		UserManager userManager;
	
		@Test
		public void testAddUser() {
			//DatabaseUserManager databaseUserManager = new DatabaseUserManager();
			
			User user = new User();
			user.setBalance(100.0);
			user.setCreateTime(new Date());
			user.setLastEditTime(new Date());
			user.setEmail("2@qq.com");
			user.setPassword("123");
			user.setUserName("test3");
			this.userManager.addUser(user);
			
		}
}
