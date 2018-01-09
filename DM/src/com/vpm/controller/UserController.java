package com.vpm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.vpm.entity.Permissions;
import com.vpm.entity.User;
import com.vpm.service.PermissService;
import com.vpm.service.UserService;

@Controller
public class UserController {
	@Autowired 
	UserService userService;
	@Autowired
	PermissService permissService;
	//adduser?u_name=a&u_pword=123
	@RequestMapping(value="/adduser",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String addUser(String u_name,String u_pword) {
		return "结果"+userService.addUser(u_name, u_pword).toString();
	}
	@RequestMapping("/asd")
	public String index(){
		return "index";
	}
	@RequestMapping(value="/finduser",produces = {"application/json;charset=UTF-8"})
	public String findUser(HttpSession session,String u_name,String u_pword) {
		User user = new User();
		user =  (User) userService.findUser(u_name, u_pword);
		int u_id = user.getU_id();
		String string =user.getU_name();
		String string2 = user.getU_pword();
		if (string.equals(u_name) && string2.equals(u_pword)) {
			session.setAttribute("u_id", u_id);
			return "redirect:/asd";
		}
		return "index2";
	}
	
	@RequestMapping(value="/findalluser",produces = {"application/json;charset=UTF-8"})
	//@ResponseBody
	public void findAllUser(HttpServletResponse response) throws Exception {
		List<User> users = new ArrayList<>();
		users = userService.findAllUser();
		String string = JSON.toJSONString(users);
		//return string;
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string);
	}

}
