package com.niit.collaborationBackEndTestCases;

import java.util.Date;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.DAO.UserDAO;
import com.niit.collaboration.model.User;

public class UserTestCases {

	
	//Logger log = LoggerFactory.getLogger(UserTestCases.class);
	

	private static UserDAO userDAO;
	
	
	User user;
	
	
	private static AnnotationConfigApplicationContext context;

	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testAdd()
	{
		//log.info("Add User Test started");
		user=new User();
		user.setUsername("srihari");
		user.setFirst_name("srihari");
		user.setLast_name("hari");
		user.setDob(new Date());
		user.setGender('M');
		user.setMail_id("srihari@gmail.com");
		user.setPassword("srihari");
		user.setStatus('N');
		user.setRole("STUDENT");
		
		//userDAO.addUser(user);
		assertEquals("User added!",true, userDAO.addUser(user));
	//	log.info("Add User Test end");
	}
	
}
