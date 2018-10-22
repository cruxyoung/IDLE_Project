package com.idle.app.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idle.app.common.ServerResponse;
import com.idle.app.domain.Comment;
import com.idle.app.domain.Item;
import com.idle.app.domain.User;
import com.idle.app.domain.ViewRecord;

@Service(value = "viewRecordManager")
@Transactional
public class ViewRecordManager {

	private SessionFactory sessionFactory;
	@Autowired
	ItemManager itemManager;
	@Autowired
	UserManager userManager;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Transactional
	public ServerResponse<String> addRecord(Item item, User user) {

		try {
			ViewRecord record = new ViewRecord();
			
			if(item==null||user==null) {
				return ServerResponse.createByErrorMessage("specify item or user!");
			}
			record.setItem(item);
			record.setUser(user);
			this.sessionFactory.getCurrentSession().save(record);
			return ServerResponse.createBySuccess();
			
		} catch (TransactionException e) {
			throw new RuntimeException("add record error: " + e.getMessage());
		} catch (Exception e) {
			return ServerResponse.createByErrorMessage("Add comment failed!");
		}

	}
	
//	Query by user
	public ServerResponse<List<ViewRecord>> getRecordsByUser(User user){
		if(user==null) return ServerResponse.createByErrorMessage("please specify user");
		String queryString = "FROM ViewRecord where user.id=:user";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		List<ViewRecord> res = query.setParameter("user", user.getUserId()).list();
		return ServerResponse.createBySuccess("query successfully", res);
	}
}
