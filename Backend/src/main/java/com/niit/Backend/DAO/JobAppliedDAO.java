package com.niit.Backend.DAO;

import java.util.List;

import com.niit.Backend.Domain.Job;
import com.niit.Backend.Domain.JobApplied;

public interface JobAppliedDAO 
{
	
	public boolean applyNew(JobApplied jobApplied);
	
	public List<JobApplied> listByUser(String username);
	
	public List<JobApplied> listByCompany();
	
}
