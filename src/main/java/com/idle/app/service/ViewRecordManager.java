package com.idle.app.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idle.app.common.ServerResponse;
import com.idle.app.domain.Address;
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
			record.setCreateTime(new Date());
			record.setLastEditTime(new Date());
			record.setStatus(new Long(0));
			if(checkRecord(item, user).getData())
				this.sessionFactory.getCurrentSession().save(record);
			else {
				updateLastEditTime(item, user);
			}
			return ServerResponse.createBySuccess();
			
		} catch (TransactionException e) {
			throw new RuntimeException("add record error: " + e.getMessage());
		} catch (Exception e) {
			return ServerResponse.createByErrorMessage("Add comment failed!");
		}

	}
	
	public ServerResponse<Boolean> checkRecord(Item item, User user){
		if(item==null||user==null) return ServerResponse.createByErrorMessage("missing item or user");
		Session currentSeesion = this.sessionFactory.getCurrentSession();
		String queryString = "from ViewRecord where user.id=? and item.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		List<ViewRecord> res = query.setParameter(0, user.getUserId()).setParameter(1, item.getId()).list();
		return ServerResponse.createBySuccess("", res.isEmpty());
		
	}
	
//	Query by user
	public ServerResponse<List<ViewRecord>> getRecordsByUser(User user){
		if(user==null) return ServerResponse.createByErrorMessage("please specify user");
		String queryString = "FROM ViewRecord where user.id=:user";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		List<ViewRecord> res = query.setParameter("user", user.getUserId()).list();
		return ServerResponse.createBySuccess("query successfully", res);
	}
	
//	Query by user
	public ServerResponse<List<ViewRecord>> getFavoriteRecordsByUser(User user){
		if(user==null) return ServerResponse.createByErrorMessage("please specify user");
		String queryString = "FROM ViewRecord where user.id=:user and status=1";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		List<ViewRecord> res = query.setParameter("user", user.getUserId()).list();
		return ServerResponse.createBySuccess("query successfully", res);
	}
	
	public ServerResponse<String> deleteViewRecord(Long viewRecordId){
		try {
			if (viewRecordId == null)
				return ServerResponse.createByErrorMessage("Can not find address");
			ViewRecord viewRecord = getViewRecordById(viewRecordId).getData();
			Session currentSession = this.sessionFactory.getCurrentSession();
			currentSession.delete(viewRecord);
			return ServerResponse.createBySuccessMessage("Delete the view record successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return ServerResponse.createByErrorMessage("fail to delete the view record, caused by: " + e.getMessage());
		}
	}
	public ServerResponse<String> deleteFavoriteRecord(Long viewRecordId){
		try {
			if (viewRecordId == null)
				return ServerResponse.createByErrorMessage("Can not find address");
			getViewRecordById(viewRecordId);
			
			//change the status is enough, means still have the record which is not favorited now
			Session session = sessionFactory.getCurrentSession();
			String hql = "update ViewRecord v set v.status=? where v.id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, 0L);
			query.setParameter(1, viewRecordId);
			query.executeUpdate();
			return ServerResponse.createBySuccessMessage("Delete the favorite record successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return ServerResponse.createByErrorMessage("fail to delete the favorite record, caused by: " + e.getMessage());
		}
	}

	public ServerResponse<ViewRecord> getViewRecordById(Long viewRecordId){
		Session currentSession = this.sessionFactory.getCurrentSession();

		ViewRecord viewRecord = (ViewRecord) currentSession.get(ViewRecord.class, viewRecordId);
		if (viewRecord == null) {
			return ServerResponse.createByErrorMessage("Cannot find the viewRecord! Please Reload!");
		}
		return ServerResponse.createBySuccess("Get the viewRecord successfully!", viewRecord);
	}
	
//	update lastedittime
	public ServerResponse<String> updateLastEditTime(Item item, User user){
		if(item==null||user==null) return ServerResponse.createByErrorMessage("missing item or user");
		Session currentSeesion = this.sessionFactory.getCurrentSession();
		String queryString = "from ViewRecord where user.id=? and item.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		ViewRecord res = (ViewRecord)query.setParameter(0, user.getUserId()).setParameter(1, item.getId()).uniqueResult();
		res.setLastEditTime(new Date());
		return ServerResponse.createBySuccess();
	}
	
	public ServerResponse<String> changeFavStatus(Item item,User user){
		if(item==null||user==null) return ServerResponse.createByErrorMessage("missing item or user");
		Session currentSeesion = this.sessionFactory.getCurrentSession();
		String queryString = "from ViewRecord where user.id=? and item.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		ViewRecord res = (ViewRecord)query.setParameter(0, user.getUserId()).setParameter(1, item.getId()).uniqueResult();
		if(res!=null)
			res.setStatus(res.getStatus()^1);
		return ServerResponse.createBySuccess();
	}
	
	public ServerResponse<ViewRecord> getRecord(Item item, User user){
		if(item==null||user==null) return ServerResponse.createByErrorMessage("missing item or user");
		Session currentSeesion = this.sessionFactory.getCurrentSession();
		String queryString = "from ViewRecord where user.id=? and item.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		ViewRecord res = (ViewRecord)query.setParameter(0, user.getUserId()).setParameter(1, item.getId()).uniqueResult();
		return ServerResponse.createBySuccess("", res);
	}
	
	
}
