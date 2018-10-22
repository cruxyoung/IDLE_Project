package com.idle.app.service;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.idle.app.BaseTest;
import com.idle.app.common.ServerResponse;
import com.idle.app.domain.Address;
import com.idle.app.domain.User;

public class DatabaseAddressManagerTest extends BaseTest{

	@Autowired
	private AddressManager addressmanager;
	
	@Test
	@Ignore
	public void testAddAddress() {
		Address address = new Address();
		address.setAddress("USYD Syd");
		address.setReceiverName("Drink juice");
		address.setReceiverPhone("01428171512");
		address.setCreateTime(new Date());
		address.setLastEditTime(new Date());
		User user = new User();
		user.setUserId(16L);
		address.setUser(user);
		
		ServerResponse<String> re = this.addressmanager.addAddress(address);
		System.out.println(re.getStatus()+"\n" +re.getMsg());
		
	}
	
	@Test
	@Ignore
	public void testUpdateAddress() {
		Address address = new Address();
		address.setAddressId(1L);
		address.setAddress("Ashfield Sydney");
		address.setReceiverName("Cong Linnnn");
		address.setReceiverPhone("0410611196");
		address.setLastEditTime(new Date());
		
		ServerResponse<String> re = this.addressmanager.updateAddress(address);
		System.out.println(re.getStatus()+"\n" +re.getMsg());
	}
	
	@Test
	@Ignore
	public void testGetAllAddressByUserId() {
		Long userId = 1L;
		ServerResponse<List<Address>> re = this.addressmanager.getAllAddressByUserId(userId);
		for(Address ad: re.getData()) {
			System.out.println(ad.getReceiverName());
		}
	}
	
	@Test
//	@Ignore
	public void testDeleteAddress() {
		Long addressId = 7L;
		ServerResponse<String> re = this.addressmanager.deleteAddress(addressId);
		System.out.println(re.getStatus()+"\n" +re.getMsg());
	}
}
