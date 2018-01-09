package com.vpm.dao;

import java.util.List;

import com.vpm.entity.User;

public interface UserDao {
	
	public void addUser(Object entity);
	
	public Object findUser(String u_name,String u_pword);

	public List<User> findAllUser();

	public Object findByid(int u_id);

	
}
