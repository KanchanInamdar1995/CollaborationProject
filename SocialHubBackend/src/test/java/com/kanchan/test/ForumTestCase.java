package com.kanchan.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kanchan.dao.ForumDAO;
import com.kanchan.model.Blog;
import com.kanchan.model.Forum;

public class ForumTestCase
{
	static ForumDAO forumDAO;

	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.kanchan");
		context.refresh();

		forumDAO = (ForumDAO) context.getBean("forumDAO");

	}
	
	@Test
	public void addForumTestCase() 
	{
		Forum forum = new Forum();
		forum.setForumName("Javascript Forum");
		forum.setForumContent("Javascript Frameworks");
		forum.setCreateDate(new java.util.Date());
		forum.setLoginname("rajesh");
		forum.setStatus("NA");
		assertTrue("Problem in Creating Forum", forumDAO.addForum(forum));
	}
	@Ignore
	@Test
	public void deleteForumTestCase()
	{
		Forum forum = forumDAO.getForum(52);
		assertTrue("Problem in deletion of the Forum", forumDAO.deleteForum(forum));
	}
	@Ignore
	@Test
	public void updateForumTestCase()
	{
		Forum forum = forumDAO.getForum(1);
		forum.setForumName("Spring Forums");

		assertTrue("Problem in Forum Updation", forumDAO.updateForum(forum));
	}
	@Test
	public void listForumTestCase()
	{
		List<Forum> listForums=forumDAO.listForums();
		assertTrue("Problem in Listing Forums",listForums.size()>0);
		for(Forum forum:listForums)
		{
			System.out.print(forum.getForumId()+":::");
			System.out.print(forum.getForumName()+":::");
			System.out.println(forum.getForumContent());
		}
	
	}
	@Test
	public void approveForumTestCase()
	{
		assertTrue("Problem in Approving Forum", forumDAO.approveForum(1));
	}
	@Ignore
	@Test
	public void rejectForumTestCase()
	{
		assertTrue("Problem in Rejecting Forum", forumDAO.rejectForum(1));
	}
}
