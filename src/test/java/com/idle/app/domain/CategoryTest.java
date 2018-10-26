package com.idle.app.domain;

import java.util.Date;

import org.junit.Test;

import com.idle.app.BaseTest;

public class CategoryTest extends BaseTest{
	private Category category = new Category();
	
	@Test
	public void testSetAndGetCategoryId() {
		Long categoryId = 5L;
		assertNull(category.getCategoryId());
		category.setCategoryId(categoryId);
		assertEquals(categoryId, category.getCategoryId());

	}
	
	@Test
	public void testSetAndGetCategoryName() {
		String categoryName = "name";
		assertNull(category.getCategoryName());
		category.setCategoryName(categoryName);
		assertEquals(categoryName, category.getCategoryName());

	}
	
	@Test
	public void testSetAndGetCreateTime() {
		Date createTime = new Date();
		assertNull(category.getCreateTime());
		category.setCreateTime(createTime);
		assertEquals(createTime, category.getCreateTime());
	}

	@Test
	public void testSetAndGetLastEditTime() {
		Date lastEditTime = new Date();
		assertNull(category.getCreateTime());
		category.setLastEditTime(lastEditTime);
		assertEquals(lastEditTime, category.getLastEditTime());
	}

}
