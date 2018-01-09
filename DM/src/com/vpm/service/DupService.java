package com.vpm.service;

import java.util.List;

import com.vpm.entity.Document;
import com.vpm.entity.Dup;
import com.vpm.entity.File;
import com.vpm.entity.Permissions;

public interface DupService {
	
	public Object addDupD(int d_id,int u_id,int p_id);
	public Object addDupF(int f_id,int u_id,List<Integer> listp);
	public List<Dup> findByUD(int p_id, int d_id, int u_id);
	public List<Dup> findDup(int d_id);
	public void updateDup(int d_id, int u_id);
	public void deleteDup(Dup dup);
	public void addDups(int dd_id, Document document);
	public List<Dup> findDuplist(List<Integer> iList);
	public void addDupsf(int d_id, File file);
	public List<Dup> findDupf(int f_id);
	public void cleanDup(int d_id, int u_id);
	public Dup addDupDf(int f_id, int u_id, int p_id);
	public List<Dup> findByPFU(int p_id, int f_id, int u_id1);
	public void updateDupf(int f_id, int u_id);
	public Dup addDupDF(int f_id, int u_id, int p_id1);
	public void cleanDupf(int f_id, int u_id);
	 
}
