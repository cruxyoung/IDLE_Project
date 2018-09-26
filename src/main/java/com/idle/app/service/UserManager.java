package com.idle.app.service;

import java.io.Serializable;

import com.idle.app.domain.User;

public interface UserManager extends Serializable{

	public void addUser(User user);
}
