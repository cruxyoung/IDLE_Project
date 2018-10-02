package com.idle.app.service;

import java.io.Serializable;

import com.idle.app.common.ServerResponse;
import com.idle.app.domain.User;

public interface UserManager extends Serializable{
	
	void add(User user);
	ServerResponse<String> addUser(User user);
	ServerResponse<String> checkUsername(String username);
	ServerResponse<String> checkEmail(String email);
	ServerResponse<String> updateUser(User user);
	ServerResponse<String> deleteUser(Long userId);
	
	
	
}
