package com.idle.app.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.idle.app.domain.Item;

@Service(value = "goodServiceImpl")
public class GoodsServiceImpl implements IGoodsService {

	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	@Transactional
	public List<Item> findbySearch(String type, String name, String sort) {
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "from Item where category.id = :categoryId and name like :name order by " + sort;
		
		List<Item> list = null;
		
		
		if (StringUtils.isEmpty(type)&&!StringUtils.isEmpty(name)) {
			sql = "from Item where  name like ? order by " + sort ;
			Query query = session.createQuery(sql);
			query.setString(0, "%" + name + "%");
			list = query.setMaxResults(8).list();

		} else if(StringUtils.isEmpty(type)&&StringUtils.isEmpty(name)) {
			sql = "from Item order by " + sort ;
			Query query = session.createQuery(sql);
			list = query.setMaxResults(8).list();
		}
		else {
			System.out.println(sql);
			Query query = session.createQuery(sql.toString());
			query.setParameter("categoryId", new Long(type));
			query.setParameter("name", "%" + name + "%");
			System.out.println(query.toString());
			list = query.setMaxResults(8).list();
			System.out.println(list);
			
		}
//		if(list.isEmpty()) {
//			String ssql = "from Item";
//			Query query = session.createQuery(ssql);
//			list=query.setMaxResults(8).list();
//		}
		
		while(list.size()>0&&list.size()<8) {
			Item item = new Item();
			item.setDescription("");
			item.setPhoto("\\app\\resources\\images\\sample.png");
			list.add(item);
		}
			
		for(Item i : list) {
			System.out.println(i);
		}
		return list;
	}

	@Override
	@Transactional
	public List<Item> findBanner() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Item where isbanner=:banner order by visitTime desc");
		
		List<Item> list = query.setParameter("banner", "1").setMaxResults(7).list();
		return list;
	}

}
