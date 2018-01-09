package com.vpm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vpm.dao.UserDao;
import com.vpm.entity.User;
import com.vpm.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userdao;

	@Override
	public Object addUser(String u_name, String u_pword) {
		User user = new User(u_name, u_pword);
		userdao.addUser(user);
		return user;
	}

	@Override
	public Object findUser(String u_name, String u_pword) {
		return userdao.findUser(u_name, u_pword);
	}

	@Override
	public List<User> findAllUser() {
		return userdao.findAllUser();
	}

}
