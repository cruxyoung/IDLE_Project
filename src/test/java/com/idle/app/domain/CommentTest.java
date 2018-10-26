package com.idle.app.domain;

import java.util.Date;

import org.junit.Test;

import com.idle.app.BaseTest;

public class CommentTest extends BaseTest{
	private Comment comment = new Comment();
	
	@Test
	public void testSetAndGetCommentId() {
		Long commentId = 5L;
		assertNull(comment.getId());
		comment.setId(commentId);
		assertEquals(commentId, comment.getId());

	}
	
	@Test
	public void testSetAndGetCommentContent() {
		String content = "comment content";
		assertNull(comment.getContent());
		comment.setContent(content);
		assertEquals(content, comment.getContent());

	}
	
	@Test
	public void testSetAndGetUser() {
		User user = new User();
		assertNull(comment.getUser());
		comment.setUser(user);;
		assertEquals(user, comment.getUser());
	}
	
	@Test
	public void testSetAndGetItem() {
		Item item = new Item();
		assertNull(comment.getItem());
		comment.setItem(item);
		assertEquals(item, comment.getItem());
	}
	
	@Test
	public void testSetAndGetCreateTime() {
		Date createTime = new Date();
		assertNull(comment.getCreateTime());
		comment.setCreateTime(createTime);
		assertEquals(createTime, comment.getCreateTime());
	}

	@Test
	public void testSetAndGetLastEditTime() {
		Date lastEditTime = new Date();
		assertNull(comment.getCreateTime());
		comment.setLastEditTime(lastEditTime);
		assertEquals(lastEditTime, comment.getLastEditTime());
	}
}
