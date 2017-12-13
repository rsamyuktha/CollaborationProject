package com.niit.Backend.DAO;

import java.util.List;

import com.niit.Backend.Domain.User;

public interface UserDAO 
{
  public boolean addUser(User user);
  public boolean updateOnlineStatus(String status,User user);
  public User getUser(String username);
  public boolean checkLogin(User userPart);
  public List<User> getAllUsers();
  
}