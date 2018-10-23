package com.idle.app.service;

import java.util.ArrayList;
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
import com.idle.app.domain.Address;
import com.idle.app.domain.Item;
import com.idle.app.domain.User;

@Service(value = "addressManager")
@Transactional
public class DatabaseAddressManager implements AddressManager {

	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	@Transactional
	public ServerResponse<String> addAddress(Address address) {
		try {
			this.sessionFactory.getCurrentSession().save(address);
			return ServerResponse.createBySuccessMessage("Add address Successfully!");
		} catch (TransactionException e) {
			throw new RuntimeException("add address error:" + e.getMessage());
		} catch (Exception e) {
			return ServerResponse.createByErrorMessage("Fail to Add Address, please check the input and network!");
		}
	}

	@Override
	@Transactional
	public ServerResponse<String> updateAddress(Address address) {
		try {

			if (address == null || address.getAddressId() == null) {
				return ServerResponse.createByErrorMessage("Cannot find this address, Try again!");
			}

			Session session = sessionFactory.getCurrentSession();
			String hql = "update Address u set u.address=?, u.receiverName=?, u.receiverPhone=?, u.lastEditTime=? where u.addressId=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, address.getAddress());
			query.setParameter(1, address.getReceiverName());
			query.setParameter(2, address.getReceiverPhone());
			query.setParameter(3, new Date());
			query.setParameter(4, address.getAddressId());
			query.executeUpdate();
			return ServerResponse.createBySuccessMessage("Update address Successfully!");

		} catch (TransactionException e) {
			throw new RuntimeException("update address error:" + e.getMessage());
		} catch (Exception e) {
			return ServerResponse.createByErrorMessage("Fail to Update Address, please check the input and network!");
		}
	}

	@Override
	public ServerResponse<String> deleteAddress(Long addressId) {
		try {
			if (addressId == null)
				return ServerResponse.createByErrorMessage("Can not find address");
			Address address = getAddressById(addressId).getData();
			Session currentSession = this.sessionFactory.getCurrentSession();
			currentSession.delete(address);
			return ServerResponse.createBySuccessMessage("Delete the address successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			return ServerResponse.createByErrorMessage("fail to delete address, caused by: " + e.getMessage());
		}
	}

	@Override
	public ServerResponse<Address> getAddressById(Long addressId) {
		Session currentSession = this.sessionFactory.getCurrentSession();

		Address address = (Address) currentSession.get(Address.class, addressId);
		if (address == null) {
			return ServerResponse.createByErrorMessage("Cannot find the address! Please Reload!");
		}
		return ServerResponse.createBySuccess("Get the address successfully!", address);
	}

	@Override
	public ServerResponse<List<Address>> getAllAddressByUserId(Long userId) {
		List<Address> list = new ArrayList<Address>();

		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM Address a where a.user.userId=?");
			query.setParameter(0, userId);
			list = query.list();
			return ServerResponse.createBySuccess("Get the addresses successfully!", list);
		} catch (Exception e) {
			return ServerResponse.createByErrorMessage(e.getMessage());
		}

	}

}
