package com.niit.collaboration.testDAO;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.DAO.JobAppliedDAO;
import com.niit.collaboration.DAO.JobDAO;
import com.niit.collaboration.model.Job;
import com.niit.collaboration.model.JobApplied;
import com.niit.collaboration.util.Date_Time;

public class TestJobApplied 
{
	Logger log = LoggerFactory.getLogger(TestUser.class);
	
	@Autowired
	JobAppliedDAO jobAppliedDAO;
	
	@Autowired
	JobDAO jobDAO;
	
	@Autowired
	Job job;
	
	@Autowired
	JobApplied jobApplied;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	public TestJobApplied()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();

		jobAppliedDAO = (JobAppliedDAO) context.getBean("jobAppliedDAO");
		jobApplied = (JobApplied) context.getBean("jobApplied");
		jobDAO = (JobDAO) context.getBean("jobDAO");
		job = (Job) context.getBean("job");
	}
	
	public void addJob()
	{
		jobApplied.setUsername("chinz1994");
		
		job = jobDAO.getJob("My Second Job");
		jobApplied.setCompany(job.getCompany());
		jobApplied.setLocation(job.getLocation());
		jobApplied.setPosition(job.getPosition());
		jobApplied.setStatus(job.getStatus());
		jobApplied.setTitle(job.getTitle());
		
		Date_Time dt = new Date_Time();
		String date = dt.getDateTime();
		jobApplied.setDate(date);
		
		jobAppliedDAO.applyNew(jobApplied);
		System.out.println("New Job has been Applied");
	}
	
	public void getListbyUser()
	{
		String username = "deadstone_kk";
		List<JobApplied> jobs = jobAppliedDAO.listByUser(username);
		System.out.println("Size "+jobs.size());
		for(JobApplied job: jobs)
		{
			System.out.println("JOB APPLIED -"+job.getTitle()+"\t JOB POSITION -"+job.getPosition()+" \t Applied by "+job.getUsername());
		}
	}
	
	public void getListbyJob()
	{
		String title = "My Second Job";
		List<JobApplied> jobs = jobAppliedDAO.listByCompany();
		System.out.println("Size "+jobs.size());
		for(JobApplied job: jobs)
		{
			System.out.println("JOB APPLIED -"+job.getTitle()+"\t JOB POSITION -"+job.getPosition()+" \t Applied by "+job.getUsername());
		}
	}
	
	public static void main(String[] args) 
	{
		TestJobApplied tj = new TestJobApplied();
//		tj.addJob();
//		tj.getListbyUser();
		tj.getListbyJob();
	}
}
