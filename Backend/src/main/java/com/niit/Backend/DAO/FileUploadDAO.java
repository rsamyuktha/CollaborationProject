package com.niit.Backend.DAO;

import com.niit.Backend.Domain.FileUpload;

public interface FileUploadDAO 
{
	public void save(FileUpload fileUpload, String username);
	public FileUpload getFile(String username);
}
