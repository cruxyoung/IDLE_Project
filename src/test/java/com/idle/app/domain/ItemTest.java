package com.idle.app.domain;
import junit.framework.TestCase;


public class ItemTest extends TestCase{
	private Item item;
	
	protected void setUp() throws Exception{
		item =new Item();
	}
	
	public void testSetAndGetDescription() {
        String name = "aDescription";
        assertNull(item.getName());
        item.setName(name);
        assertEquals(name, item.getName());
    }	
}
