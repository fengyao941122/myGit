package com.vpm.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.vpm.entity.Document;
import com.vpm.entity.Dup;
import com.vpm.entity.Permissions;
import com.vpm.entity.User;
import com.vpm.entity.UserPermissions;
import com.vpm.service.DocumentService;
import com.vpm.service.DupService;
import com.vpm.service.FileService;

@Controller
public class DupController {

	@Autowired
	DupService dupService;
	@Autowired
	DocumentService documentService;
	@Autowired
	FileService fileservice;

	// 添加文件夹权限
	@RequestMapping(value = "/addDupD", produces = { "application/json;charset=UTF-8" })
	public void addDupD(int d_id, int u_id, String listp, HttpServletResponse response) throws Exception {
		String[] ids = listp.split(",");
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < ids.length; i++) {
			list.add(Integer.parseInt(ids[i]));
		}
		List<Dup> dups = new ArrayList<>();
		for (Integer p_id : list) {
			Dup dup = (Dup) dupService.addDupD(d_id, u_id, p_id);
			dups.add(dup);
		}
		String string3 = JSON.toJSONString(dups);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string3);
	}

	//
	@RequestMapping(value = "/addDupF", produces = { "application/json;charset=UTF-8" })
	public void addaddDupF(int f_id, int u_id, String listp, HttpServletResponse response) throws Exception {
		String[] ids = listp.split(",");
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < ids.length; i++) {
			list.add(Integer.parseInt(ids[i]));
		}
		List<Dup> dups = new ArrayList<>();
		for (Integer p_id : list) {
			Dup dup = (Dup) dupService.addDupDf(f_id, u_id, p_id);
			dups.add(dup);
		}
		String string3 = JSON.toJSONString(dups);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string3);
	}

	// 修改权限
	@RequestMapping(value = "/updateDup", produces = { "application/json;charset=UTF-8" })
	public void updateDup(int d_id, int u_id, int p_id, String listp, HttpSession session, HttpServletResponse response)
			throws Exception {
		// 判断是否有权限
		int u_id1 = (int) session.getAttribute("u_id");
		System.out.println(u_id1);
		System.out.println(d_id);
		System.out.println(p_id);
		List<Dup> dups1 = dupService.findByUD(p_id, d_id, u_id1);
		int i1 = dups1.size();
		if (i1 == 0) {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write("20");
		} else {
			dupService.updateDup(d_id, u_id);
			String[] ids = listp.split(",");
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < ids.length; i++) {
				list.add(Integer.parseInt(ids[i]));
			}
			List<Dup> dups = new ArrayList<>();
			for (Integer p_id1 : list) {
				Dup dup = (Dup) dupService.addDupD(d_id, u_id, p_id1);
				dups.add(dup);
			}
			String string3 = JSON.toJSONString(dups);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write("30");
		}
	}

	// 修改权限文件
	@RequestMapping(value = "/updateDupf", produces = { "application/json;charset=UTF-8" })
	public void updateDupf(int f_id, int u_id, int p_id, String listp, HttpSession session,
			HttpServletResponse response) throws Exception {
		// 判断是否有权限
		int u_id1 = (int) session.getAttribute("u_id");
		List<Dup> dups1 = dupService.findByPFU(p_id, f_id, u_id1);
		int i1 = dups1.size();
		if (i1 == 0) {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write("20");
		} else {
			dupService.updateDupf(f_id, u_id);
			String[] ids = listp.split(",");
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < ids.length; i++) {
				list.add(Integer.parseInt(ids[i]));
			}
			List<Dup> dups = new ArrayList<>();
			for (Integer p_id1 : list) {
				Dup dup = (Dup) dupService.addDupDF(f_id, u_id, p_id1);
				dups.add(dup);
			}
			String string3 = JSON.toJSONString(dups);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write("30");
		}
	}

	// 查看所有权限
	@RequestMapping(value = "/findDup", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public void findDup(int d_id, HttpServletResponse response) throws Exception {
		List<Integer> iList = new ArrayList<>();
		int d_id4 = d_id;
		while (documentService.findFaDocument(d_id).getInherit() == 1) {
			iList.add(documentService.findFaDocument(d_id).getDd_id());// 集合添加当前父文件夹ID30
			d_id = documentService.findFaDocument(d_id).getDd_id();
		}
		List<Dup> dups = dupService.findDup(d_id4);
		// Set<UserPermissions> userPermissions =new HashSet<>();
		// for (Dup dup : dups) {
		// User user = dup.getUser();
		// Permissions permissions = dup.getPermissions();
		// UserPermissions userPermissions2 = new UserPermissions(user, permissions);
		// userPermissions.add(userPermissions2);
		// }
		// List<Dup> dup3 = dups;
		// for (Integer d_id1 : iList) {
		// List<Dup> dups1 = dupService.findDup(d_id1);
		// for (Dup dup : dups1) {
		// dups.add(dup);
		// }
		//
		// }
		String string3 = JSON.toJSONString(dups, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(string3);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string3);
	}

	@RequestMapping(value = "/judgeD", produces = { "application/json;charset=UTF-8" })
	public void judgeDelete(int d_id, HttpSession session, HttpServletResponse response) throws Exception {
		List<Integer> iList = new ArrayList<>();
		iList.add(d_id);
		while (documentService.findFaDocument(d_id).getInherit() == 1) {
			iList.add(documentService.findFaDocument(d_id).getDd_id());// 集合添加当前父文件夹ID30
			d_id = documentService.findFaDocument(d_id).getDd_id();
		}
		List<Dup> dups = dupService.findDuplist(iList);
		String string3 = JSON.toJSONString(dups, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(string3);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string3);
	}

	// 查看所有权限文件
	@RequestMapping(value = "/findDupf", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public void findDupf(int f_id, HttpServletResponse response) throws Exception {
		List<Integer> iList = new ArrayList<>();
		int f_id4 = f_id;
		// while (fileservice.findFafile(f_id).getInherit()==1) {
		// iList.add(fileservice.findFafile(f_id).getDd_id());//集合添加当前父文件夹ID30
		// f_id=fileservice.findFafile(f_id).getDd_id();
		// }
		if (fileservice.findfile(f_id).getInherit() == 1) {
			int d_id = fileservice.findFafile(f_id).getD_id();
			System.out.println(d_id);
			iList.add(documentService.findFaDocument(d_id).getD_id());
			while (documentService.findFaDocument(d_id).getInherit() == 1) {
				iList.add(documentService.findFaDocument(d_id).getD_id());// 集合添加当前父文件夹ID30
				d_id = documentService.findFaDocument(d_id).getDd_id();
			}
		}

		System.out.println(iList);

		List<Dup> dups = dupService.findDupf(f_id4);
		Set<UserPermissions> userPermissions = new HashSet<>();
		for (Dup dup : dups) {
			User user = dup.getUser();
			Permissions permissions = dup.getPermissions();
			UserPermissions userPermissions2 = new UserPermissions(user, permissions);
			userPermissions.add(userPermissions2);
		}
		List<Dup> dup3 = dups;
		for (Integer d_id1 : iList) {
			List<Dup> dups1 = dupService.findDup(d_id1);
			for (Dup dup : dups1) {
				dups.add(dup);
			}

		}
		String string3 = JSON.toJSONString(dups, SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(string3);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string3);
	}

	// 清除权限
	@RequestMapping(value = "/cleanDup", produces = { "application/json;charset=UTF-8" })
	public void cleanDup(int d_id, int u_id, int p_id, HttpSession session, HttpServletResponse response)
			throws Exception {
		// 判断是否有权限
		int u_id1 = (int) session.getAttribute("u_id");
		List<Dup> dups1 = dupService.findByUD(p_id, d_id, u_id1);
		int i1 = dups1.size();
		if (i1 == 0) {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write("20");
		} else {
			dupService.cleanDup(d_id, u_id);
			// String string3 = JSON.toJSONString(dups);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write("30");
		}
	}

	// 清除权限 文件
	@RequestMapping(value = "/cleanDupf", produces = { "application/json;charset=UTF-8" })
	public void cleanDupf(int f_id, int u_id, int p_id, HttpSession session, HttpServletResponse response)
			throws Exception {
		// 判断是否有权限
		int u_id1 = (int) session.getAttribute("u_id");
		List<Dup> dups1 = dupService.findByPFU(p_id, f_id, u_id1);
		int i1 = dups1.size();
		if (i1 == 0) {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write("20");
		} else {
			dupService.cleanDupf(f_id, u_id);
			// String string3 = JSON.toJSONString(dups);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write("30");
		}
	}

}
