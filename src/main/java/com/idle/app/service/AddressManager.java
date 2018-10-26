package com.idle.app.service;

import java.io.Serializable;
import java.util.List;

import com.idle.app.common.ServerResponse;
import com.idle.app.domain.Address;
import com.idle.app.domain.User;

public interface AddressManager extends Serializable {
	/**
	 * add new address
	 * 
	 * @param address
	 * @return
	 */
	ServerResponse<String> addAddress(Address address);

	/**
	 * update the existed address
	 * 
	 * @param address
	 * @return
	 */
	ServerResponse<String> updateAddress(Address address);

	/**
	 * delete the address by address Id
	 * 
	 * @param addressId
	 * @return
	 */
	ServerResponse<String> deleteAddress(Long addressId);

	/**
	 * get the address by address Id
	 * 
	 * @param addressId
	 * @return
	 */
	ServerResponse<Address> getAddressById(Long addressId);

	/**
	 * get all the addresses by one user Id
	 * 
	 * @param userId
	 * @return
	 */
	ServerResponse<List<Address>> getAllAddressByUserId(Long userId);
}
