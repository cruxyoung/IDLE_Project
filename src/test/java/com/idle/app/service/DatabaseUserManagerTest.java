package com.idle.app.service;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.idle.app.BaseTest;
import com.idle.app.common.ServerResponse;
import com.idle.app.domain.User;

public class DatabaseUserManagerTest extends BaseTest {

	@Autowired
	private UserManager userManager;
	
//	@Resource(name = "userManager")
//	UserManager userManager;

	@Test
	@Ignore
	public void testAdd() {
		// DatabaseUserManager databaseUserManager = new DatabaseUserManager();

		User user = new User();
		user.setBalance(100.0);
		user.setCreateTime(new Date());
		user.setLastEditTime(new Date());
		user.setEmail("xili@qq.com");
		user.setPassword("123");
		user.setUserName("testnew");
		user.setPhone("12345");
		this.userManager.add(user);
		// System.out.println(response.getMsg());

	}

	@Test
	@Ignore
	public void testAddUser() {
		// DatabaseUserManager databaseUserManager = new DatabaseUserManager();

		User user = new User();
		user.setBalance(100.0);
		user.setCreateTime(new Date());
		user.setLastEditTime(new Date());
		user.setEmail("xili@qq.com");
		user.setPassword("123");
		user.setUserName("lixinnn");
		user.setPhone("1234333566");
		ServerResponse<String> re = this.userManager.addUser(user);
		System.out.println(re.getMsg());
		// assertEquals(0, re.getStatus());

	}

	@Test
	@Ignore
	public void testUpdateUser() {
		User user = new User();
		user.setUserId(1L);

		user.setBalance(4.0);
		user.setEmail("4@1.com");
		user.setPhone("411111");
		user.setUserName("updateTest4");

		ServerResponse<String> re = this.userManager.updateUser(user);
		System.out.println(re.getMsg());
	}

	@Test
	@Ignore
	public void testCheckUsername() {
		String username = "3testnew";
		ServerResponse<String> re = this.userManager.checkUsername(username);
		System.out.println(re.getMsg() + " " + re.getStatus());
	}

	@Test
	@Ignore
	public void testCheckEmail() {
		String email = "3new@qq.com";
		ServerResponse<String> re = this.userManager.checkEmail(email);
		System.out.println(re.getMsg() + " " + re.getStatus());
	}
	
	@Test
	public void testLogin() {
		String username = "test3";
		String password = "123";
		ServerResponse<?> re = this.userManager.login(username, password);
		System.out.println(re.getMsg()+ " " + re.getStatus());
	}
}
