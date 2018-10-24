package com.idle.app.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idle.app.domain.Order;

@Service(value = "orderManager")
@Transactional
public class OrderManager {
	private SessionFactory sessionFactory;
	private List<Order> orders;

	@Autowired
	private UserManager userManager;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

}
