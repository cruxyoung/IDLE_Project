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

@Service(value="commentManager")
@Transactional
public class CommentManager  {
	private SessionFactory sessionFactory;
	
	@Autowired
	ItemManager itemManager;
	@Autowired
	UserManager userManager;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
//	Create
	@Transactional
	public ServerResponse<String> addComments(String content, Item item, User user){
		try {
			if(content==null) {
				return ServerResponse.createByErrorMessage("cannot find content");
			}
			Comment comment = new Comment();
			comment.setContent(content);
//			item = new Item();
//			user = new User();
			if(item==null||user==null) 
				return ServerResponse.createByErrorMessage("cannot find item or user");
			comment.setItem(item);
			comment.setUser(user);
			this.sessionFactory.getCurrentSession().save(comment);
			return ServerResponse.createBySuccess("add comment successfully");
			
			
		} catch (TransactionException e) {
			throw new RuntimeException("add comment error: " + e.getMessage());
		} catch (Exception e) {
			return ServerResponse.createByErrorMessage("Add comment failed!");
		}
	}
//	Query by user
	public ServerResponse<List<Comment>> getCommentsByUser(User user){
		if(user==null) return ServerResponse.createByErrorMessage("please specify user");
		String queryString = "FROM Comment where user=:user";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		List<Comment> res = query.setParameter("user", user.getUserId()).list();
		return ServerResponse.createBySuccess("query successfully", res);
	}
//	Query by item
	public ServerResponse<List<Comment>> getCommentsByItem(Item item){
		if(item==null) return ServerResponse.createByErrorMessage("please specify item");
		String queryString = "FROM Comment where item.id=:item";
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryString);
		List<Comment> res = query.setParameter("item", item.getId()).list();
		return ServerResponse.createBySuccess("query successfully", res);
	}
	
//	Delete
	public ServerResponse<String> deleteComment(Long id){
		try{
			if(id==null) return ServerResponse.createByErrorMessage("no id provided");
			Session currentSession = this.sessionFactory.getCurrentSession();
			Comment comment = (Comment) currentSession.get(Comment.class, id);
			currentSession.delete(comment);
			return ServerResponse.createBySuccess();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.toString());
			return ServerResponse.createByErrorMessage("delete faild, caused by: "
				+e.toString());
		}
	}
	
	
	
}
