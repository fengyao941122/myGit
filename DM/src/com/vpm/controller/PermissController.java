package com.vpm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.vpm.entity.Permissions;
import com.vpm.service.PermissService;

@Controller
@RequestMapping()
public class PermissController {
	
	@Autowired
	PermissService permissService;
	
	@RequestMapping("/login")
	public String index(){
		return "index2";
	}
	//addp?permissions=add
	@RequestMapping(value="/addp",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String addPermiss(String permissions) {
		return "保存成功："+permissService.addPermiss(permissions).toString();
	}
	
	@RequestMapping(value="/findp",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public void findPermiss(HttpServletResponse response) throws Exception {
		//Permissions_PageBean permissions_PageBean = new Permissions_PageBean();
		List<Permissions> permissions_List = permissService.findPermiss();
		//permissions_PageBean.setPermissions_list(permissions_List);
		String string2 = new String();
		string2 = JSON.toJSONString(permissions_List);
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(string2);
	}

}
