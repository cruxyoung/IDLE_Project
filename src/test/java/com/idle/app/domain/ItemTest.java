package com.idle.app.domain;
import org.junit.Before;
import org.junit.Test;

import com.idle.app.BaseTest;


public class ItemTest extends BaseTest{
	private Item item=new Item();
	
	
	@Test
	public void testSetAndGetName() {
        String name = "aDescription";
        assertNull(item.getName());
        item.setName(name);
        assertEquals(name, item.getName());
    }	
	@Test
	public void testSetAndGetDescription() {
		String desc="this is a Description";
		assertNull(item.getDescription());
		item.setDescription(desc);
		assertEquals(desc, item.getDescription());
	}
}
