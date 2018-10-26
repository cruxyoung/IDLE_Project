package com.idle.app.service;

import java.io.Serializable;

import com.idle.app.common.ServerResponse;
import com.idle.app.domain.User;

public interface UserManager extends Serializable {
	/**
	 * add method to test add a user using Hibernate unused
	 * 
	 * @param user
	 */
	void add(User user);

	/**
	 * add user method for log in function
	 * 
	 * @param user
	 * @return
	 */
	ServerResponse<String> addUser(User user);

	/**
	 * to check if the user name has existed for register or log in function
	 * 
	 * @param username
	 * @return
	 */
	ServerResponse<String> checkUsername(String username);

	/**
	 * to check if the email has existed for register or log in function
	 * 
	 * @param email
	 * @return
	 */
	ServerResponse<String> checkEmail(String email);

	/**
	 * update the user for modify user personal info function
	 * 
	 * @param user
	 * @return
	 */
	ServerResponse<String> updateUser(User user);

	/**
	 * delete the user
	 * 
	 * @param userId
	 * @return
	 */
	ServerResponse<String> deleteUser(Long userId);

	/**
	 * log in with user name and password
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	ServerResponse<User> login(String username, String password);

	/**
	 * get the user object by user Id
	 * 
	 * @param userId
	 * @return
	 */
	ServerResponse<User> getUserByUserId(Long userId);

	/**
	 * update the user balance for top up function
	 * 
	 * @param user
	 * @return
	 */
	ServerResponse<String> updateBalance(User user);

}
