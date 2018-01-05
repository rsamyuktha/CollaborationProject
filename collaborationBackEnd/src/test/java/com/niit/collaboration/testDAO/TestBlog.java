package com.niit.collaboration.testDAO;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.DAO.BlogDAO;
import com.niit.collaboration.model.Blog;

public class TestBlog
{
Logger log = LoggerFactory.getLogger(TestUser.class);
	
	@Autowired
	BlogDAO blogDAO;
	
	@Autowired
	Blog blog;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public TestBlog()
	{	
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();

		blogDAO = (BlogDAO) context.getBean("blogDAO");
		blog = (Blog) context.getBean("blog");
	}
	
	public void addBlog()
	{
		blog.setBlog_title("N2 th Blog");
		blog.setDescription("Hello2");
		blog.setUsername("testdone1");
		blog.setDate_time("DATE_TIME");
		blogDAO.addBlog(blog);
		System.out.println("Success?");
	}
	
	public void updateBlog()
	{
		blog.setBlog_title("Second Blog");
		blog.setDescription("Hello");
		blog.setUsername("Admin");
		blog.setDate_time("DATE_TIME");
		blogDAO.updateBlog(blog);
		System.out.println("Update Success");
	}
	
	public void approveBlog()
	{
		blog.setBlog_title("Second Blog");
		blog.setDescription("Hello");
		blog.setUsername("Admin");
		blog.setDate_time("DATE_TIME");
		blog.setStatus("Approved");
		blogDAO.approveBlog(blog);
		System.out.println("Approved Success");
	}
	
	public void getBlog()
	{
		blog = blogDAO.getBlog("First Blog");
		if(blog == null)
		{
			System.out.println("Blog not found");
		}	else
		{
			System.out.println("Blog");
			System.out.println("Name = "+blog.getBlog_id());
			System.out.println("Details = "+blog.getStatus());
		}
	}
	
	public void deleteBlog()
	{
		blog = blogDAO.getBlog("N th Blog");
		boolean value = blogDAO.deleteBlog(blog);
		if(value==true)
		{
			System.out.println("Blog deleted");
		} else
		{
			System.out.println("Blog not deleted");
		}
	}
	
	public void getByUser()
	{
		String usn = "testuser";
		List<Blog> list = blogDAO.getBlogByUser(usn);
		if(list == null)
		{
			System.out.println("List is Empty");
		}
		else
		{
			int size = blogDAO.getBlogByUser(usn).size();
			for(int i=0; i<size; i++)
			{
				System.out.print("Title = "+list.get(i).getBlog_title()+"\t");
				System.out.println("Status = "+list.get(i).getStatus());
			}
		}
	}
	
	public void getAll()
	{
		List<Blog> list = blogDAO.getAllBlogs();
		if(list == null)
		{
			System.out.println("List is Empty");
		}
		else
		{
			int size = blogDAO.getAllBlogs().size();
			for(int i=0; i<size; i++)
			{
				System.out.print("Title = "+list.get(i).getBlog_title()+"\t");
				System.out.println("Status = "+list.get(i).getStatus());
			}
		}
	}
	
	public void getApprovedBlog()
	{
		List<Blog> list = blogDAO.getApprovedBlogs();
		if(list == null)
		{
			System.out.println("List is Empty");
		}
		else
		{
			int size = blogDAO.getApprovedBlogs().size();
			for(int i=0; i<size; i++)
			{
				System.out.print("Title = "+list.get(i).getBlog_title()+"\t");
				System.out.println("Status = "+list.get(i).getStatus());
			}
		}
	}
	
	public static void main(String[] args) 
	{
		TestBlog tb = new TestBlog();
	tb.addBlog();
	//	tb.getAll();
//		tb.approveBlog();
//		tb.updateBlog();	
	//	tb.getBlog();
//		tb.deleteBlog();
//		tb.getByUser();
//		tb.getApprovedBlog();
		System.out.println("Success");
	}
}