package com.niit.Backend.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Backend.DAO.BlogDAO;
import com.niit.Backend.Domain.Blog;

@RestController
public class BlogController
{
    
	@Autowired
	BlogDAO blogDAO;
	
	@PostMapping(value="/insertBlog")
	
	public ResponseEntity<String> insertBlog(Blog blog)
	{
		int i=10;
	 if(blogDAO.addBlog(blog))
	 {
		 return new ResponseEntity<String>("Blog is added successfully",HttpStatus.OK);
		 
	 }
	 
	 else
	 {
		 return new ResponseEntity<String>("error in response entity",HttpStatus.SERVICE_UNAVAILABLE);
	 }
	}
	
}
