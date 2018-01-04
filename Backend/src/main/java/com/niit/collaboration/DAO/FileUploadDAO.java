package com.niit.collaboration.DAO;

import com.niit.collaboration.model.FileUpload;

public interface FileUploadDAO 
{
	public void save(FileUpload fileUpload, String username);
	public FileUpload getFile(String username);
}
