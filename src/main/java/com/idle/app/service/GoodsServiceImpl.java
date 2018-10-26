package com.idle.app.service;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.shop.web.entity.GoodsEntity;
import com.shop.web.service.IGoodsService;

@Service
public class GoodsServiceImpl extends HibernateDaoSupport
		implements
			IGoodsService
{

	@SuppressWarnings("unchecked")
	@Override
	public List<GoodsEntity> findbySearch(String type, String name, String sort)
	{
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		String sql = "select * from goods where type = ? and name like ? order by "
				+ sort + " limit 0,8";
		List<GoodsEntity> list = null;

		if (StringUtils.isEmpty(type))
		{
			sql = "select * from goods where  name like ? order by " + sort
					+ " limit 0,8";
			SQLQuery query = session.createSQLQuery(sql.toString());
			query.addEntity(GoodsEntity.class);
			query.setString(0, "%" + name + "%");
			list = query.list();
		} else
		{
			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setString(0, type);
			query.setString(1, "%" + name + "%");
			query.addEntity(GoodsEntity.class);
			list = query.list();
		}
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GoodsEntity> findBanner()
	{
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		String hql = "select * from goods where isbanner = 1";
		SQLQuery query = session.createSQLQuery(hql.toString())
				.addEntity(GoodsEntity.class);
		List<GoodsEntity> list = query.list();
		session.close();
		return list;
	}

}
