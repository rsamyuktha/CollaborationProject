package com.niit.collaboration.testDAO;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.DAO.FriendDAO;
import com.niit.collaboration.model.Friend;

public class TestFriend
{

	private static final Logger log = LoggerFactory.getLogger(TestFriend.class);
	
	@Autowired
	FriendDAO friendDAO;
	
	@Autowired
	Friend friend;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public TestFriend()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();
		
		friendDAO = (FriendDAO) context.getBean("friendDAO");
		friend = (Friend) context.getBean("friend");
	}
	
	public void addFriend()
	{
		friend.setUserID("kaustubh");
		friend.setFriendID("chinmay");
		friend.setStatus('P');
		friend.setFriendFName("Chinmay");
		friend.setUserFName("Kaustubh");
		friend.setUserIsOnline('N');
		friend.setFriendisOnline('N');
		boolean value = friendDAO.get(friend.getUserID(), friend.getFriendID());
		log.info("Value - "+value);
		if(value == true)
			friendDAO.save(friend);
		else
			System.out.println("You have already sent friend request..");
	}
	
	public void acceptFriend()
	{
		String userID = "KKKK";
		String friendID = "chinmay";
		boolean value = friendDAO.accept(userID, friendID);
		log.info("Value "+value);
		System.out.println("Success");
	}
	
	public void getFriendList()
	{
		String username = "chinmay";
		List<Friend> list = new ArrayList<Friend>();
		list = friendDAO.getFriendList(username);
		System.out.println(list);
		if(list.isEmpty())
		{
			System.out.println("Socialize bro.. u need some friends");
		}
		else
		{
//			System.out.println(list.get(0));
			for(int i = 0; i<list.size(); i++)
				System.out.println(list.get(i).getFriendFName());
//				System.out.println("Friend Name - "+list.get(i).getFriendID()+list.get(i).getUserID());
		}
	}
	
	public void removeFriend()
	{
		String userID = "XYZ";
		String friendID = "Varun";
		friendDAO.removeFriend(userID, friendID);
	}
	
	public void setOnline()
	{
		boolean x = friendDAO.setUsersOnline("chinmay");
		if(x)
			System.out.println("Success...");
		else
			System.out.println("Update Failed");
	}

	public void setOffline()
	{
		boolean x = friendDAO.setUsersOffline("chinmay");
		if(x)
			System.out.println("Success...");
		else
			System.out.println("Update Failed");
	}
	
	public static void main(String[] args) 
	{
		TestFriend test = new TestFriend();
//		test.addFriend();
//		test.acceptFriend();
//		test.removeFriend();
//		test.getFriendList();
//		test.setOnline();
		test.setOffline();
	}
}
