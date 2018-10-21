package com.idle.app.service;

import java.io.Serializable;
import java.util.List;

import com.idle.app.common.ServerResponse;
import com.idle.app.domain.Address;
import com.idle.app.domain.User;

public interface AddressManager extends Serializable{
	ServerResponse<String> addAddress(Address address);
	
	ServerResponse<String> updateAddress(Address address);
	
	ServerResponse<String> deleteAddress(Long addressId);
	
	ServerResponse<Address> getAddressById(Long addressId);
	
	ServerResponse<List<Address>> getAllAddressByUserId(Long userId);
}
