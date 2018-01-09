package com.vpm.dao;

import java.util.List;

import com.vpm.entity.Dup;
import com.vpm.entity.Permissions;

public interface DupDao {
	
	public void addDup(Object entity);

	public Object findByUD(int p_id, int d_id, int u_id);

	public Object findDup(int d_id);

	public void deleteDup(Object entity);

	public Object findDupBydu(int d_id, int u_id);
	
	public void updateDup(Object entity);

	public Object findDuplist(List<Integer> iList);

	public Object findbyfid(int f_id);

	public List<Dup> findByPFU(int p_id, int f_id, int u_id1);

	public List<Dup> findDupByfu(int f_id, int u_id);

}
