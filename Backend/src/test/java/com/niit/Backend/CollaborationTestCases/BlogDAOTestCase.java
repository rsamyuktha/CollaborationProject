package com.niit.Backend.CollaborationTestCases;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.DAO.BlogDAO;
import com.niit.Backend.Domain.Blog;


public class BlogDAOTestCase {

	static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend");
		context.refresh();
		
		blogDAO=(BlogDAO)context.getBean("blogDAO");
	}
	/*
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		
		blog.setBlogId(2017);
		blog.setBlogName("C");
		blog.setBlogContent("It contains simple C Concept");
		blog.setUsername("samyu");
		blog.setStatus("A");
		blog.setLikes(6);
		blog.setCreateDate(new java.util.Date());;
		
		assertTrue("Problem in Inserting Blog",blogDAO.addBlog(blog));
	
	}

	@Test
	public void getBlogTest()
	{
		Blog blog=blogDAO.getBlog(2016);
        assertNotNull("blog not found",blog);
        
        System.out.println("Blog Name is:"+blog.getBlogName());
        System.out.println("Blog Content is:"+blog.getBlogContent());
	}
	/*@Ignore
	@Test
	public void getAllBlogTest()
	{
		List<Blog> blog=(List<blogDAO>).getAllBlogs();
        assertNotNull("blog list not found",blogList.get(0));
        
        for(BlogPart blog:blogList)
        {
        System.out.println("Blog Id"+blog.getBlogId()+"-----"+"Bolg Name"+blog.getBlogName());
	    }
     }
	
	@Test
	public void deleteBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(2017);
		assertTrue("Problem in deletion",blogDAO.deleteBlog(blog));
	}
	
	@Test
	public void updateBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(2016);
		blog.setBlogContent("Features of C, Storage variables,Looping, Files ,Data Structure");
        blog.setBlogName("C++");
        assertTrue("Problem in updation",blogDAO.updateBlog(blog));
	}
	
	@Test
	public void approveBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(2016);
	    assertTrue("Problem in updation",blogDAO.updateBlog(blog));
	}
	
	@Test
	public void rejectBlogTest()
	{
		Blog blog=(Blog)blogDAO.getBlog(2016);
	    assertTrue("Problem in updation",blogDAO.rejectBlog(blog));
	}
	*/
}