package com.vpm.service;

import java.util.List;

import com.vpm.entity.User;

public interface UserService {
	
	

	public Object addUser(String u_name,String u_pword);
	
	public Object findUser(String u_name,String u_pword);

	public List<User> findAllUser();

}
