package com.idle.app.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idle.app.domain.Order;

@Service(value = "orderManager")
@Transactional
public class OrderManager {
	private SessionFactory sessionFactory;
	

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	// C
	public void addOrder(Order order) {
		this.sessionFactory.getCurrentSession().save(order);

	}

	// D
	public void deleteOrder(Integer orderId) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Order order = (Order) currentSession.get(Order.class, orderId);
		currentSession.delete(order);
	}

	// U
	public void updateOrder(Order order) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(order);
	}

	public Order getOrderByOrderId(int orderId) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Order o where o.id= ? ");
		Order order = (Order) query.setInteger(0, orderId).uniqueResult();
		return order;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
