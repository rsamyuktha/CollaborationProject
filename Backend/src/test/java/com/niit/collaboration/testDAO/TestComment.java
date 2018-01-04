package com.niit.collaboration.testDAO;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.DAO.CommentDAO;
import com.niit.collaboration.model.BlogComment;
import com.niit.collaboration.util.Date_Time;

public class TestComment 
{
	private static final Logger log = LoggerFactory.getLogger(TestComment.class);
	
	@Autowired 
	CommentDAO commentDAO;
	
	@Autowired
	BlogComment blogComment;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public TestComment()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();
		
		blogComment = (BlogComment) context.getBean("blogComment");
		commentDAO = (CommentDAO) context.getBean("commentDAO");
	}

	public void addBlogComment()
	{
		blogComment.setComment("Good information");
		blogComment.setBlog_id("Aeroplane");
		Date_Time dt = new Date_Time();
		blogComment.setPostedAt(dt.getDateTime());
		blogComment.setRating(4);
		blogComment.setUsername("testuser");
		log.info("Comment Recieved "+blogComment.getComment());
		boolean value = commentDAO.addBlogComment(blogComment);
		log.info("Added comment "+value);
	}
	
	public void deleteComment()
	{
		int id  = 122;
		boolean value = commentDAO.deleteComment(id);
		log.info("Delete comment "+value);
	}
	
	public void list()
	{
		String blog = "Aeroplane";
		List<BlogComment> list = commentDAO.getBlogComments(blog);
		System.out.println(list);
		System.out.println(list.size());
		if(list == null || list.isEmpty())
		{
			System.out.println("No comments found");	
		}
		else
		{
			for(BlogComment bc : list)
			{
				System.out.println(bc.getComment());
			}
		}
	}
	
	public static void main(String[] args)
	{
		TestComment tc = new TestComment();
//		tc.addBlogComment();
//		tc.deleteComment();
		tc.list();
		System.out.println("Success");
	}
}
