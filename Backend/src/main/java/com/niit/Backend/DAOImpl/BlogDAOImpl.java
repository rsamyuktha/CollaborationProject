package com.niit.Backend.DAOImpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.DAO.BlogDAO;
import com.niit.Backend.Domain.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	
	public boolean addBlog(Blog blog) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(blog);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

	public boolean updateBlog(Blog blog) {
		
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured..........."+e);
			return false;
		}
		
	}

	@Transactional
	
	public boolean deleteBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception has occured..........."+e);
			return false;
		}
		
	}

	
	public Blog getBlog(int blogId) {
		Session session=sessionFactory.openSession();
		Blog blog =(Blog)session.get(Blog.class,blogId);
		session.close();
		return blog;
	}

	
	public List<Blog> getAllBlogs() {
		Session session=sessionFactory.openSession();
		List<Blog> blogList =(List<Blog>)session.createQuery("from Blog");
		session.close();
		return blogList;
	}

	
	public boolean approveBlog(Blog blog) {
		try
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);	
		    return true;
	    }
        catch(Exception e)
		{
        	System.out.println("Exception has occured"+e);
        	return false;
		}
   }		
	
	
	public boolean rejectBlog(Blog blog) {
		try
		{
			blog.setStatus("N");
			sessionFactory.getCurrentSession().update(blog);	
		    return true;
	    }
        catch(Exception e)
		{
        	System.out.println("Exception has occured"+e);
        	return false;
		}
   }		
	
	
}
