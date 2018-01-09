package com.vpm.dao;

import java.util.List;

import com.vpm.entity.File;

public interface FileDao {
	
	public void addFile(Object entity);

	public Object findById(int f_id);

	public Object findallFile(int dd_id);

	public void deleteFile(Object entity);
	
	

}
