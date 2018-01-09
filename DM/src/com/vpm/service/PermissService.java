package com.vpm.service;

import java.util.List;

import com.vpm.entity.Document;
import com.vpm.entity.Permissions;

public interface PermissService {
	
	public Object addPermiss(String permissions);
	
	public Boolean deletePermiss(int p_id);
	
	public List<Permissions>  findPermiss();

}
