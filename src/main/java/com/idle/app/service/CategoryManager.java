package com.idle.app.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idle.app.common.ServerResponse;
import com.idle.app.domain.Category;

@Service(value="categoryManager")
@Transactional
public class CategoryManager {
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;
	private List<Category> Categories;
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public List<Category> getCategories(){
		Session currentSession = this.sessionFactory.getCurrentSession();
		return currentSession.createQuery("FROM Category").list();
	
	}
	
	
	@Transactional
	public ServerResponse<String> addCategory(Category cate){
		this.sessionFactory.getCurrentSession().save(cate);
		return ServerResponse.createBySuccess();
	}
	
	
	public void deleteAllCategory(String myTable) {
		String hql = String.format("delete from %s", myTable);
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();

	}
	
	public Category getCateByName(String cateName) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Category where categoryName=:categoryName");
		Category cate = (Category) query.setParameter("categoryName", cateName).uniqueResult();
		return cate;
	}
	
	

	
}
