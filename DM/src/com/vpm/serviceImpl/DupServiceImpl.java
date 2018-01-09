package com.vpm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vpm.dao.DocumentDao;
import com.vpm.dao.DupDao;
import com.vpm.dao.FileDao;
import com.vpm.dao.PermissDao;
import com.vpm.dao.UserDao;
import com.vpm.entity.Document;
import com.vpm.entity.Dup;
import com.vpm.entity.File;
import com.vpm.entity.Permissions;
import com.vpm.entity.User;
import com.vpm.service.DupService;

@Service
public class DupServiceImpl implements DupService {
	@Autowired
	DupDao duodao;
	@Autowired
	DocumentDao documentdao;
	@Autowired
	UserDao userdao;
	@Autowired
	PermissDao permissdao;
	@Autowired
	FileDao filedao;

	@Override
	public Object addDupD(int d_id, int u_id, int p_id) {
		Document document = (Document) documentdao.findById(d_id);
		User user = (User) userdao.findByid(u_id);
		Permissions permissions = (Permissions) permissdao.findById(p_id);
		Dup dup = new Dup(document, user, permissions);
		duodao.addDup(dup);
		return dup;
	}

	@Override
	public Object addDupF(int f_id, int u_id, List<Integer> listp) {
		File file = (File) filedao.findById(f_id);
		User user = (User) userdao.findByid(u_id);
		for (Integer integer : listp) {
			Permissions permissions = (Permissions) permissdao.findById(integer);
			Dup dup = new Dup(file, user, permissions);
			duodao.addDup(dup);
		}
		return null;
	}

	@Override
	public List<Dup> findByUD(int p_id, int d_id,int u_id) {
		List<Dup> pList = (List<Dup>) duodao.findByUD(p_id,d_id,u_id);
		return pList;
	}

	@Override
	public List<Dup> findDup(int d_id) {
		return (List<Dup>) duodao.findDup(d_id);
	}

	@Override
	public void updateDup(int d_id ,int u_id) {
		List<Dup> dups = (List<Dup>) duodao.findDupBydu(d_id,u_id);
		System.out.println(dups);
		for (Dup dup : dups) {
			duodao.deleteDup(dup);
		}
		
	}

	@Override
	public void deleteDup(Dup dup) {
		duodao.deleteDup(dup);
	}

	@Override
	public void addDups(int dd_id, Document document) {
		List<Dup> dups = (List<Dup>) duodao.findDup(dd_id);
		for (Dup dup : dups) {
			User user = dup.getUser();
			Permissions permissions  = dup.getPermissions();
			Dup dup2 = new Dup(document, user, permissions);
			//dup.setDocument(document);
			duodao.addDup(dup2);
		}
	}

	@Override
	public List<Dup> findDuplist(List<Integer> iList) {
		// TODO Auto-generated method stub
		 return (List<Dup>) duodao.findDuplist(iList);
	}

	@Override
	public void addDupsf(int d_id, File file) {
		List<Dup> dups = (List<Dup>) duodao.findDup(d_id);
		for (Dup dup : dups) {
			User user = dup.getUser();
			Permissions permissions  = dup.getPermissions();
			Dup dup2 = new Dup(file, user, permissions);
			duodao.addDup(dup2);
		}
		
	}

	@Override
	public List<Dup> findDupf(int f_id) {
		
		return (List<Dup>) duodao.findbyfid(f_id);
	}

	@Override
	public void cleanDup(int d_id, int u_id) {
		List<Dup> dups = (List<Dup>) duodao.findDupBydu(d_id,u_id);
		for (Dup dup : dups) {
			duodao.deleteDup(dup);
		}
	}

	@Override
	public Dup addDupDf(int f_id, int u_id, int p_id) {
		File file = (File) filedao.findById(f_id);
		User user = (User) userdao.findByid(u_id);
		Permissions permissions = (Permissions) permissdao.findById(p_id);
		Dup dup = new Dup(file, user, permissions);
		duodao.addDup(dup);
		return dup;
	}

	@Override
	public List<Dup> findByPFU(int p_id, int f_id, int u_id1) {
		List<Dup> pList = (List<Dup>) duodao.findByPFU(p_id,f_id,u_id1);
		return pList;
	}

	@Override
	public void updateDupf(int f_id, int u_id) {
		List<Dup> dups = (List<Dup>) duodao.findDupByfu(f_id,u_id);
		System.out.println(dups);
		for (Dup dup : dups) {
			duodao.deleteDup(dup);
		}
	}

	@Override
	public Dup addDupDF(int f_id, int u_id, int p_id1) {
		File file = (File) filedao.findById(f_id);
		User user = (User) userdao.findByid(u_id);
		Permissions permissions = (Permissions) permissdao.findById(p_id1);
		Dup dup = new Dup(file, user, permissions);
		duodao.addDup(dup);
		return dup;
	}

	@Override
	public void cleanDupf(int f_id, int u_id) {
		List<Dup> dups = (List<Dup>) duodao.findDupByfu(f_id, u_id);
		for (Dup dup : dups) {
			duodao.deleteDup(dup);
		}
	}

}
