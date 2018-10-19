package com.idle.app.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idle.app.common.ServerResponse;
import com.idle.app.domain.Item;
import com.idle.app.domain.User;

@Service(value = "userManager")
@Transactional
public class DatabaseUserManager implements UserManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	/**
	 * add a new user
	 */
	@Override
	@Transactional
	public ServerResponse<String> addUser(User user) {

		try {
			// check user name
			ServerResponse<String> res = checkUsername(user.getUserName());
			if (res.getStatus() != 0)
				return res;

			// check email
			res = checkEmail(user.getEmail());
			if (res.getStatus() != 0)
				return res;

			// add the user
			this.sessionFactory.getCurrentSession().save(user);
			return ServerResponse.createBySuccessMessage("Sign Up Successfully!");
		} catch (TransactionException e) {
			throw new RuntimeException("add user error:" + e.getMessage());
		} catch (Exception e) {
			return ServerResponse.createByErrorMessage("Fail to SignUp, please check the input and network!");
		}

	}

	/**
	 * update the user information
	 */
	@Override
	@Transactional
	public ServerResponse<String> updateUser(User user) {
		try {
			if (user == null || user.getUserId() == null) {
				return ServerResponse.createByErrorMessage("Cannot find this user, Try again!");
			}
			// check user name
			ServerResponse<String> res = checkUsername(user.getUserName());
			if (res.getStatus() != 0)
				return res;

			// check email
			res = checkEmail(user.getEmail());
			if (res.getStatus() != 0)
				return res;

			Session session = sessionFactory.getCurrentSession();
			// session.beginTransaction();
			String hql = "update User u set u.userName=?, u.email=?, u.phone=?, u.lastEditTime=? where u.userId=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getUserName());
			query.setParameter(1, user.getEmail());
			query.setParameter(2, user.getPhone());
			query.setParameter(3, new Date());
			query.setParameter(4, user.getUserId());
			query.executeUpdate();
			// session.getTransaction().commit();
			return ServerResponse.createBySuccessMessage("Update Information successfully!");
		} catch (TransactionException e) {
			throw new RuntimeException("update user error:" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return ServerResponse.createByError();

		}
	}

	@Override
	public void add(User user) {
		// for test
		this.sessionFactory.getCurrentSession().save(user);

	}

	/**
	 * Check if the user name has existed
	 */
	@Override
	public ServerResponse<String> checkUsername(String username) {
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery("from User u where u.userName=?");
			query.setString(0, username);
			List<?> list = query.list();
			if (list.isEmpty()) {
				return ServerResponse.createBySuccess();
			} else {
				return ServerResponse.createByErrorMessage(username + " username has existed! Please Try Another...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return ServerResponse.createByError();
		}

	}

	/**
	 * check if the email has existed
	 */
	@Override
	public ServerResponse<String> checkEmail(String email) {
		try {
			Query query = this.sessionFactory.getCurrentSession().createQuery("from User u where u.email=?");
			query.setString(0, email);
			List list = query.list();
			if (list.isEmpty()) {
				return ServerResponse.createBySuccess();
			} else {
				return ServerResponse.createByErrorMessage(email + " email has existed! Please Try Another...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return ServerResponse.createByError();
		}
	}

	@Override
	@Transactional
	public ServerResponse<String> deleteUser(Long userId) {
		try {
			// todo delete user

		} catch (TransactionException e) {
			throw new RuntimeException("delete user error:" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return ServerResponse.createByError();

		}
		return null;
	}

	@Override
	public ServerResponse<User> login(String username, String password) {
		// check user name
		ServerResponse<String> res = checkUsername(username);
		if (res.getStatus() == 0)
			return ServerResponse.createByErrorMessage("Username is wrong!");
		else {
			
			try {
				Query query = this.sessionFactory.getCurrentSession().createQuery("from User u where u.userName=? and u.password=?");
				query.setString(0, username);
				query.setString(1, password);
				List <User>list = query.list();
				if (list.isEmpty()) {
					return ServerResponse.createByErrorMessage("Fail to login, your password is wrong!");
				} else {
					return ServerResponse.createBySuccess("Log in successfully!", list.get(0));
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.toString());
				return ServerResponse.createByError();
			}
		}
	}

	@Override
	public ServerResponse<User> getUserByUserId(Long userId) {
		Session currentSession = this.sessionFactory.getCurrentSession();

		User user = (User) currentSession.get(User.class, userId);
		return ServerResponse.createBySuccess("Get the user successfully!", user);
	}

}
