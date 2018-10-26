package com.idle.app.domain;

import java.util.Date;

import org.junit.Test;

import com.idle.app.BaseTest;

public class UserTest extends BaseTest {
	private User user = new User();
	
	@Test
	public void testSetAndGetUserId() {
		Long userId = 5L;
		assertNull(user.getUserId());
		user.setUserId(userId);
		assertEquals(userId, user.getUserId());
		
	}
	
	@Test
	public void testSetAndGetUserName() {
        String userName = "username";
        assertNull(user.getUserName());
        user.setUserName(userName);
        assertEquals(userName, user.getUserName());
    }
	
	@Test
	public void testSetAndGetPassword() {
        String password = "password";
        assertNull(user.getPassword());
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }
	
	@Test
	public void testSetAndGetEmail() {
        String email = "email";
        assertNull(user.getEmail());
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }
	
	@Test
	public void testSetAndGetBalance() {
        Double balance = 20.2;
        assertNull(user.getBalance());
        user.setBalance(balance);
        assertEquals(balance, user.getBalance());
    }
	
	@Test
	public void testSetAndGetPhone() {
        String phone = "1233121313";
        assertNull(user.getPhone());
        user.setPhone(phone);
        assertEquals(phone, user.getPhone());
    }
	
	@Test
	public void testSetAndGetCreateTime() {
		Date createTime = new Date();
		assertNull(user.getCreateTime());
		user.setCreateTime(createTime);
		assertEquals(createTime, user.getCreateTime());
	}
	
	@Test
	public void testSetAndGetLastEditTime() {
		Date lastEditTime = new Date();
		assertNull(user.getCreateTime());
		user.setLastEditTime(lastEditTime);
		assertEquals(lastEditTime, user.getLastEditTime());
	}
	
}
