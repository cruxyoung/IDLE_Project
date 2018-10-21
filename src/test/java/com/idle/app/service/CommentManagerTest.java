package com.idle.app.service;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.idle.app.BaseTest;
import com.idle.app.domain.Category;
import com.idle.app.domain.Item;
import com.idle.app.domain.User;

public class CommentManagerTest extends BaseTest {

	@Resource(name = "itemManager")
	private ItemManager itemManager;
	
	@Autowired
	private CategoryManager categoryManager;
	
	
	@Before
	public void setUp() throws Exception {
		String[] cates = {"Antiques","Baby","Boats","Books","Cars","Clothing","Community","Electronics","Home","Jobs","Others"};
	     for(String s:cates) {
	    	 Category category = new Category();
	    	 category.setCategoryName(s);
	    	 this.categoryManager.addCategory(category);
	     }
	}
	
	@Test
	public void testInjection() {
		assertEquals(0,0);
		System.out.println("do nothing");
		

	}

}
