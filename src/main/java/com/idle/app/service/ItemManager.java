package com.idle.app.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idle.app.common.ServerResponse;
import com.idle.app.domain.Comment;
import com.idle.app.domain.Item;
import com.idle.app.domain.User;

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
	@Transactional
	public ServerResponse<String> addItem(Item item) {

		try {
			if (item == null) {
				return ServerResponse.createByErrorMessage("cannot find item");
			}
			item.setIsbanner("1");
			item.setVisitTime(new Long(0));
			ServerResponse<String> res = checkItemName(item.getName());
			if (res.getStatus() != 0) {
				return res;
			}
			this.sessionFactory.getCurrentSession().save(item);
			return ServerResponse.createBySuccess("Add item successfully!");

		} catch (TransactionException e) {
			throw new RuntimeException("add item error: " + e.getMessage());
		} catch (Exception e) {
			return ServerResponse.createByErrorMessage("Add item failed!");
		}

	}

	private ServerResponse<String> checkItemName(String itemName) {
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery("from Item it where it.name=? ");
			query.setString(0, itemName);
			List list = query.list();
			if (list.isEmpty()) {
				return ServerResponse.createBySuccess();
			} else {
				return ServerResponse.createByErrorMessage(itemName + "item name has already existed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return ServerResponse.createByError();
		}
	}

	// D
	@Transactional
	public ServerResponse<String> deleteItem(Long id) {
		try{
			if(id==null) return ServerResponse.createByErrorMessage("no id provided");
			Session currentSession = this.sessionFactory.getCurrentSession();
			Item item = (Item) currentSession.get(Item.class, id);
			currentSession.delete(item);
			return ServerResponse.createBySuccessMessage("Delete successfully!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.toString());
			return ServerResponse.createByErrorMessage("delete faild, caused by: "
				+e.toString());
		}
		
	}

	// U
	@Transactional
	public ServerResponse<String> updateItem(Item item) {
		try{
			if (item == null || item.getId() == null) {
				return ServerResponse.createByErrorMessage("cannot find item");
			}
			Session currentSession = this.sessionFactory.getCurrentSession();

			currentSession.merge(item);
			return ServerResponse.createBySuccess();
		}catch(TransactionException e){
			throw new RuntimeException("update user error:" + e.getMessage());

		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.toString());
			return ServerResponse.createByError();
		}
	}

	// R
	public Item getItemById(Long id) {
		Session currentSession = this.sessionFactory.getCurrentSession();

		Item item = (Item) currentSession.get(Item.class, id);
		return item;
	}

	public Item getItemByName(String name) {
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
//	get all items by user
	public ServerResponse<List<Item>>  getItemsByUser(User user){
		if(user==null) return ServerResponse.createByErrorMessage("specify your user!");
		try {
			Session currentSession = this.sessionFactory.getCurrentSession();
			String queryString = "from Item where owner.userId=:user order by lastEditTime Desc";
			Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
			List<Item> res = query.setParameter("user", user.getUserId()).list();
			return ServerResponse.createBySuccess("query success",res);
		}catch(Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("Search failed");
		}
	}

}
