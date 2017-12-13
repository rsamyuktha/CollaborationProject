package com.niit.Backend.CollaborationTestCases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Backend.DAO.UserDAO;
import com.niit.Backend.Domain.User;
import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
@Repository("userDAO")
public class UserDAOTestCase {

static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.Backend");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	

	@Test
	public void addUserTest()
	{
		User user=new User();
		 user.setUsername("samyuktha");
		 user.setFirstname("R");
		 user.setLastname("samyu");
		 user.setPassword("2626");
		 user.setEmailId("samyu@gmail.com");
		 user.setRole("Admin");
		 user.setIsOnline("N");
		assertTrue("Problem in Inserting User",userDAO.addUser(user));
	
	}
	
	@Test
	public void isOnlineTest()
	{
		User user=userDAO.getUser("samyuktha");
		assertTrue("Problem in assertion..",userDAO.updateOnlineStatus("Y", user));
	}

}
