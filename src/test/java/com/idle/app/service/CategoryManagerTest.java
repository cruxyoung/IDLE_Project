package com.idle.app.service;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.idle.app.BaseTest;
import com.idle.app.common.ServerResponse;
import com.idle.app.domain.Category;

public class CategoryManagerTest extends BaseTest {

	@Autowired
	private CategoryManager categoryManager;
	
	@Test
	@Ignore
	public void testGetCategories() {
		assertEquals(11, this.categoryManager.getCategories().size());
	}
	
	@Test
	@Ignore
	public void testAddCategory() {
		Category cate = new Category();
		cate.setCategoryName("test");
		cate.setCreateTime(new Date());
		cate.setLastEditTime(new Date());
		ServerResponse<String> re = this.categoryManager.addCategory(cate);
		assertEquals(0, re.getStatus());
	}
	
	@Test
	@Ignore
	public void testDeleteAllCategory() {
		this.categoryManager.deleteAllCategory("category");
		assertEquals(0, this.categoryManager.getCategories().size());
	}
	
	@Test
	@Ignore
	public void testGetCategoryByName() {
		Category cate = this.categoryManager.getCateByName("Books");
		assertEquals("Books", cate.getCategoryName());
	}
}

