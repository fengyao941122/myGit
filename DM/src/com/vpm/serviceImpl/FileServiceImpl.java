package com.vpm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vpm.dao.DocumentDao;
import com.vpm.dao.FileDao;
import com.vpm.entity.Document;
import com.vpm.entity.File;
import com.vpm.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	FileDao filedao;
	@Autowired
	DocumentDao documentdao;

	@Override
	public Object addFile(int d_id, int inherit, String f_name, String f_url) {
		Document document = (Document) documentdao.findById(d_id);
		File file = new File(d_id, f_name, f_url,inherit);
		filedao.addFile(file);
		return file;
	}

	@Override
	public List<File> findallFile(int dd_id) {

		return (List<File>) filedao.findallFile(dd_id);
	}

	@Override
	public File updateInherit(int f_id, int inherit) {
		File file = (File) filedao.findById(f_id);
		file.setInherit(inherit);
		filedao.addFile(file);
		return file;
	}

	@Override
	public void deleteFile(int f_id) {
		File file = (File) filedao.findById(f_id);
		filedao.deleteFile(file);
		
	}

	@Override
	public Document findFafile(int f_id) {
		File file = (File) filedao.findById(f_id);
		int d_id= file.getDd_id();
		Document document = (Document) documentdao.findById(d_id);
		return document;
	}

	@Override
	public File findfile(int f_id) {
		// TODO Auto-generated method stub
		return (File) filedao.findById(f_id);
	}

}
