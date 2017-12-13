package com.niit.Backend.DAOImpl;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Backend.DAO.UserDAO;
import com.niit.Backend.Domain.User;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOImpl implements UserDAO
{
    @Autowired
    public SessionFactory sessionFactory;
    
	public UserDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	
	public boolean addUser(User user) {
        try{
		sessionFactory.getCurrentSession().save(user); 
        }
        catch(Exception e)
        {
        	System.out.println("Exception has occured..."+e);
        }
		return false;
        
	}
    @Transactional
    
	public boolean updateOnlineStatus(String status, User user)
    {
    	 try
    	 {
    	   user.setIsOnline(status);	 
    	   sessionFactory.getCurrentSession().save(user); 
    	 }
    	  catch(Exception e)
    	 {
           System.out.println("Exception has occured..."+e);
    	   
    	 }
		return false;
    	 	
	}

	public User getUser(String username) {
     
		Session session= sessionFactory.openSession();
		User user=(User)session.get(User.class,username);
		session.close();
		return user;
	}

	public boolean checkLogin(User userPart) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}	
}


