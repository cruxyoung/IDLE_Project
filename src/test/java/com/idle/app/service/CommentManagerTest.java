package com.idle.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.idle.app.BaseTest;
import com.idle.app.common.ServerResponse;
import com.idle.app.domain.Category;
import com.idle.app.domain.Comment;
import com.idle.app.domain.Item;
import com.idle.app.domain.User;

public class CommentManagerTest extends BaseTest {

	@Resource(name = "itemManager")
	private ItemManager itemManager;
	
	@Autowired
	private CategoryManager categoryManager;
	
	@Autowired
	private CommentManager commentManager;
	
	@Autowired
	private UserManager userManager;
	
	@Before
	@Ignore
	public void setUp() throws Exception {
		String[] cates = {"Antiques","Baby","Boats","Books","Cars","Clothing","Community","Electronics","Home","Jobs","Others"};
	     for(String s:cates) {
	    	 Category category = new Category();
	    	 category.setCategoryName(s);
	    	 this.categoryManager.addCategory(category);
	     }
	}
	
	@Test
	@Ignore
	public void testInjection() {
		assertEquals(0,0);
		System.out.println("do nothing");
	
	}
	
	@Test
	@Ignore
	public void testAddComments() {
		Item item = this.itemManager.getItemById(17L);
		User user = this.userManager.getUserByUserId(1L).getData();
		ServerResponse<String> re = this.commentManager.addComments("test", item, user);
		assertEquals(0, re.getStatus());
	}

	@Test
	@Ignore
	public void testGetCommentsByItem() {
		Item item = this.itemManager.getItemById(17L);
		ServerResponse<List<Comment>> re = this.commentManager.getCommentsByItem(item);
		System.out.println(re.getMsg());
		assertEquals(0, re.getStatus());
	}
	
	@Test
	@Ignore
	public void testGetCommentsById() {
		ServerResponse<Comment> re = this.commentManager.getCommentsById(3L);
		System.out.println(re.getMsg());
		assertEquals(0, re.getStatus());
	}
	
	@Test
	@Ignore
	public void testDeleteComment() {
		ServerResponse<String> re = this.commentManager.deleteComment(5L);
		assertEquals(0, re.getStatus());
	}
	
	@Test
	@Ignore
	public void testUpdateComment() {
		Comment comment = this.commentManager.getCommentsById(3L).getData();
		comment.setContent("testupdate");
		ServerResponse<String> re = this.commentManager.updateComment(comment);
		assertEquals(0, re.getStatus());
	}
	
	@Test
	@Ignore
	public void testGetCommentByUser() {
		User user = this.userManager.getUserByUserId(1L).getData();
		ServerResponse<List<Comment>> re = this.commentManager.getCommentByUser(user);
		assertEquals(0, re.getStatus());
	}
}
