package com.niit.Backend.Domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Forum {
	@Id
	int forumId;
	
	String forumName;
	String forumContent;
	String username;
	String status;
	
	
	Date createDate;
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getForumId() 
	{
		return forumId;
	}
	public void setForumId(int forumId) 
	{
		this.forumId = forumId;
	}
	public String getForumName() 
	{
		return forumName;
	}
	public void setForumName(String forumName) 
	{
		this.forumName = forumName;
	}
	public String getForumContent() 
	{
		return forumContent;
	}
	public void setForumContent(String forumContent) 
	{
		this.forumContent = forumContent;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}