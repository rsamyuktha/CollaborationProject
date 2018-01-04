package com.niit.collaboration.testDAO;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.DAO.ForumDAO;
import com.niit.collaboration.DAO.ForumReplyDAO;
import com.niit.collaboration.model.Forum;
import com.niit.collaboration.model.ForumReply;
import com.niit.collaboration.util.Date_Time;

public class TestForum 
{
	private static final Logger log = LoggerFactory.getLogger(TestForum.class);

	@Autowired
	Forum forum;
	
	@Autowired
	ForumDAO forumDAO ;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public TestForum()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();
		
		forum = (Forum) context.getBean("forum");
		forumDAO = (ForumDAO) context.getBean("forumDAO");
	}
	
	public void addForum()
	{
		forum.setId(1);
		forum.setForum_id("Bikes");
		Date_Time dt = new Date_Time();
		String date = dt.getDateTime();
		forum.setDate_time(date);
		forum.setDescription("I have a budget of 20 lakhs and i need suggestions for buying a bike which will be a killer of its kind in bangalore. One should feel like a jet sonic plane is passing through when the bikes passes . Open to all suggestions on exhausts.");
		forum.setStatus('A');
		forum.setUsername("deadstone_kk");
		boolean value = forumDAO.addForum(forum);
		log.info("Forum add status "+value);
	}
	
	public void updateForum()
	{
		forum.setId(130);
		forum.setForum_id("What are some of the best rare natural phenomena that occur on Earth?");
		Date_Time dt = new Date_Time();
		String date = dt.getDateTime();
		forum.setDate_time(date);
		forum.setDescription("Let me know ASAP...");
		forum.setStatus('P');
		forum.setUsername("manasa1234");
		boolean value = forumDAO.addForum(forum);
		log.info("Forum update status "+value);
	}
	
	public void accept()
	{
		forum = forumDAO.getForum(130);
		forum.setStatus('A');
		forumDAO.updateForum(forum);
		log.info("Success");
	}
	
	public void deleteForum()
	{
		int id = 1;
		boolean value = forumDAO.deleteForum(id);
		log.info("Delete Forum value = "+value);
	}
	
	public void getForum()
	{
		int id = 1;
		Forum forum = forumDAO.getForum(id);
		System.out.println("Forum ID: "+forum.getForum_id());
		System.out.println("Description: "+forum.getForum_id());
		System.out.println("Username: "+forum.getUsername());
		System.out.println("Status: "+forum.getStatus());
	}
	
	public void listUserForum()
	{
		log.info("List Forum");
		String username = "testuser";
		List<Forum> list=  forumDAO.getUserForums(username);
		if(list == null || list.isEmpty())
		{
			System.out.println("You have no blogs");
		}
		else
		{
			for(Forum forum: list)
			System.out.println("Name - "+forum.getForum_id()+"\t Status -"+forum.getStatus()+"\t Username -"+forum.getUsername());
		}
	}
	
	public void listAllForums()
	{
		List<Forum> list=  forumDAO.getForumList();
		if(list == null || list.isEmpty())
		{
			System.out.println("You have no blogs");
		}
		else
		{
			for(Forum forum: list)
			System.out.println("Name - "+forum.getForum_id()+"\t Status -"+forum.getStatus()+"\t Username -"+forum.getUsername());
		}

	}
	
	public void viewApprovedForums()
	{
		List<Forum> list=  forumDAO.approvedForums();
		if(list == null || list.isEmpty())
		{
			System.out.println("You have no blogs");
		}
		else
		{
			for(Forum forum: list)
			System.out.println("Name - "+forum.getForum_id()+"\t Status -"+forum.getStatus()+"\t Username -"+forum.getUsername());
		}


	}
	
	public static void main(String[] args) 
	{
		TestForum test = new TestForum();
//		test.addForum();
//		test.updateForum();
//		test.deleteForum();
//		test.getForum();
//		test.accept();
		test.listUserForum();
//		test.listAllForums();
//		test.viewApprovedForums();
	}
}
