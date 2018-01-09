package com.vpm.dao;

import java.util.List;

import com.vpm.entity.Permissions;

public interface PermissDao {
	
	void addPermiss(Object entity);
	
	void deletePermiss(Object entity);
	
	Object findById(int p_id);
	
	public List<Permissions> findPermiss();

}
