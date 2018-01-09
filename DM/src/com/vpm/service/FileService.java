package com.vpm.service;

import java.util.List;

import com.vpm.entity.Document;
import com.vpm.entity.File;

public interface FileService {
	public Object addFile(int d_id, int inherit, String f_name, String f_url);

	public List<File> findallFile(int dd_id);

	public File updateInherit(int f_id, int inherit);

	public void deleteFile(int f_id);

	public Document findFafile(int f_id);

	public File findfile(int f_id);
}
