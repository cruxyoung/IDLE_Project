package com.idle.app.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idle.app.domain.Item;

@Service(value = "itemManager")
@Transactional
public class ItemManager {
	private SessionFactory sessionFactory;
	private List<Item> items;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	// C
	public void addItem(Item item) {
		this.sessionFactory.getCurrentSession().save(item);

	}

	// D
	public void deleteItem(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Item item = (Item) currentSession.get(Item.class, id);
		currentSession.delete(item);
	}

	// U
	public void updateItem(Item item) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(item);
	}

	// R
	public Item getItemById(long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();

		Item item = (Item) currentSession.get(Item.class, id);
		return item;
	}

	public Item getItemByName(String name){
		Session currentSession = this.sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Item where name=:name");
		Item item = (Item) query.setParameter("name", name).uniqueResult();
		return item;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Item").list();
	}

	public void deleteAllItems(String myTable) {
		String hql = String.format("delete from %s", myTable);
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
		
	}

}
