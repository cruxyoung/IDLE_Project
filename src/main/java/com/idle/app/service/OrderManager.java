package com.idle.app.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idle.app.common.ServerResponse;
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

	public ServerResponse<List<Order>> getAllBoughtOrderByUserId(Long userId){
		List<Order> list  = new ArrayList<Order>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM Order a where a.buyer.userId=? order by a.lastEditTime Desc");
			query.setParameter(0, userId);
			list = query.list();
			return ServerResponse.createBySuccess("Get the bought order successfully!", list);
		} catch (Exception e) {
			return ServerResponse.createByErrorMessage(e.getMessage());
		}
	}
	
	public ServerResponse<List<Order>> getAllSoldOrderByUserId(Long userId){
		List<Order> list  = new ArrayList<Order>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM Order a where a.seller.userId=? order by a.lastEditTime Desc");
			query.setParameter(0, userId);
			list = query.list();
			return ServerResponse.createBySuccess("Get the seller order successfully!", list);
		} catch (Exception e) {
			return ServerResponse.createByErrorMessage(e.getMessage());
		}
	}
}
