package com.vpm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vpm.dao.DocumentDao;
import com.vpm.dao.PermissDao;

import com.vpm.entity.Document;
import com.vpm.entity.Permissions;
import com.vpm.service.DocumentService;
import com.vpm.service.PermissService;
@Service
public class PermissServiceImpl implements PermissService{
	@Autowired
	PermissDao permissdao;
	
	@Override
	public Object addPermiss(String permissions) {
		Permissions permissions2 = new Permissions(permissions);
		permissdao.addPermiss(permissions2);
		return permissions2;
	}
	@Override
	public Boolean deletePermiss(int p_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permissions> findPermiss() {
		
		return permissdao.findPermiss();
	}
	
	
}
