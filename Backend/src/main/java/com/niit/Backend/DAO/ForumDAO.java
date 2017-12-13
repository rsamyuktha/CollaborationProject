package com.niit.Backend.DAO;

import java.util.List;

import com.niit.Backend.Domain.Forum;



public interface ForumDAO {
	public boolean addForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean deleteBlog(Forum forum);
	public Forum getBlog(int blogId);
	public List<Forum> getAllForums();
	public boolean approveBlog(Forum forum);
	public boolean rejectForum(Forum forum);

}