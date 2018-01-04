package com.niit.collaboration.testDAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.DAO.UserDAO;
import com.niit.collaboration.model.User;

public class TestUser 
{
	Logger log = LoggerFactory.getLogger(TestUser.class);
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	User user;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public TestUser()
	{
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");
		
	}
	
	public void testAdd()
	{
		log.info("Add User Test started");
		
		user.setUsername("admin");
		user.setFirst_name("admin");
		user.setLast_name("");
		user.setDob(new Date());
		user.setGender('M');
		user.setMail_id("admin@gmail.com");
		user.setPassword("admin");
		user.setStatus('Y');
		user.setRole("ADMIN");
		
		userDAO.addUser(user);
		log.info("Add User Test end");
	}
	
	public void getUserDetails()
	{
		log.info("Get User Details Started");
		String userName = "SRINU";
		user = userDAO.getUser(userName);
		System.out.println("Name - "+user.getFirst_name());
		System.out.println("Date - "+user.getDob());
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	       Date dateobj = user.getDob();
	       String datetime = df.format(dateobj).toString();
	       System.out.println("Date - "+datetime);
		log.info("Get User Ended");
	}
	
	public void validateUser()
	{
		log.info("Validate User Started");
		String userName = "testuser";
		String password = "student";
		boolean value = userDAO.validateUser(userName, password);
		if(value)
			System.out.println("Valid");
		else
			System.out.println("Invalid");
		log.info("Validate User Ended");
	}
	
	public void deleteUser()
	{
		log.info("Delete Success initiated.");
		user = userDAO.getUser("testuser");
		userDAO.deleteUser(user);
		log.info("Delete Success");
	}
	
	public void list()
	{
		log.info("List Users");
		List<User> list = userDAO.getUserList();
		int size = list.size();
		for(int index = 0; index < size; index++)
		{
			System.out.print("Name = "+list.get(index).getFirst_name());
			System.out.println("\t Email = "+list.get(index).getMail_id());
		}
	}
	
	public static void main(String[] args) 
	{
		TestUser tuser = new TestUser();
		tuser.testAdd();
//		tuser.getUserDetails();
//		tuser.validateUser();
//		tuser.deleteUser();
//		tuser.list();
		
		System.out.println("Success");
	}
}