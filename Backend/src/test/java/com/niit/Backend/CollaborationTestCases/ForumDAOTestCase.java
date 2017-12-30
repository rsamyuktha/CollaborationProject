package com.niit.Backend.CollaborationTestCases;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.DAO.ForumDAO;
import com.niit.Backend.Domain.Forum;


public class ForumDAOTestCase {

	static ForumDAO forumDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend");
		context.refresh();
		
		forumDAO=(ForumDAO)context.getBean("forumDAO");
	}
	/*
	@Test
	public void addBlogTest()
	{
		Forum forum=new Forum();
		
		forum.setForumId(1017);
		forum.setForumName("Java");
		forum.setForumContent("It contains simple java Concept");
		forum.setUsername("samyuktha");
		forum.setStatus("A");
	    forum.setCreateDate(new java.util.Date());;
		
		assertTrue("Problem in Inserting Forum",forumDAO.addForum(forum));
	
	}
    
	@Test
	public void getForumTest()
	{
		Forum forum=forumDAO.getForum(1016);
        assertNotNull("forum not found",forum);
        
        System.out.println("Forum Name is:"+forum.getForumName());
        System.out.println("Forum Content is:"+forum.getForumContent());
	}
	
	@Test
	public void getAllForumTest()
	{
		List<Forum> forum=(List<forumDAO>).getAllForums();
        assertNotNull("forum list not found",forumList.get(0));
        
        for(Forum forum:forumList)
        {
        System.out.println("Forum Id"+forum.getForumId()+"-----"+"Forum Name"+forum.getForumName());
	    }
     }
	
	@Test
	public void deleteForumTest()
	{
		Forum forum=(ForumPart)forumDAO.getforum(2017);
		assertTrue("Problem in deletion",forumDAO.deleteForum(forum));
	}
	
	@Test
	public void updateForumTest()
	{
		Forum forum=(Forum)forumDAO.getforum(1016);
		forum.setForumContent("Features of java, variables, collections ,Multithreading, Strings ");
        forum.setForumName("Core java");
        assertTrue("Problem in updation", forumDAO.updateForum(forum));
	}
	
	@Test
	public void approveForumTest()
	{
		Forum forum=(Forum)forumDAO.getForum(1016);
	    assertTrue("Problem in updation",forumDAO.updateForum(forum));
	}
	
	@Test
	public void rejectForumTest()
	{
		Forum forum=(Forum)forumDAO.getForum(1016);
	    assertTrue("Problem in updation",forumDAO.rejectForum(forum));
	}*/
	
}