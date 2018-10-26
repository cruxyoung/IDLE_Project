package com.idle.app.domain;

import java.util.Date;

import org.junit.Test;

import com.idle.app.BaseTest;

public class AddressTest extends BaseTest {

	private Address address = new Address();

	@Test
	public void testSetAndGetAddressId() {
		Long addressId = 5L;
		assertNull(address.getAddressId());
		address.setAddressId(addressId);
		assertEquals(addressId, address.getAddressId());

	}

	@Test
	public void testSetAndGetAddress() {
		String addressName = "address";
		assertNull(address.getAddress());
		address.setAddress(addressName);
		assertEquals(addressName, address.getAddress());

	}

	@Test
	public void testSetAndGetReceiverName() {
		String receiverName = "receiver name";
		assertNull(address.getReceiverName());
		address.setReceiverName(receiverName);
		assertEquals(receiverName, address.getReceiverName());

	}

	@Test
	public void testSetAndGetReceiverPhone() {
		String receiverPhone = "receiver phone";
		assertNull(address.getReceiverPhone());
		address.setReceiverPhone(receiverPhone);
		assertEquals(receiverPhone, address.getReceiverPhone());

	}

	@Test
	public void testSetAndGetCreateTime() {
		Date createTime = new Date();
		assertNull(address.getCreateTime());
		address.setCreateTime(createTime);
		assertEquals(createTime, address.getCreateTime());
	}

	@Test
	public void testSetAndGetLastEditTime() {
		Date lastEditTime = new Date();
		assertNull(address.getCreateTime());
		address.setLastEditTime(lastEditTime);
		assertEquals(lastEditTime, address.getLastEditTime());
	}

	@Test
	public void testSetAndGetUser() {
		User user = new User();
		assertNull(address.getUser());
		address.setUser(user);;
		assertEquals(user, address.getUser());
	}
}
