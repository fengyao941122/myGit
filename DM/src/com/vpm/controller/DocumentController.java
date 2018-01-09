package com.vpm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import com.vpm.entity.Document;
import com.vpm.entity.Dup;
import com.vpm.entity.File;
import com.vpm.entity.Permissions;
import com.vpm.service.DocumentService;
import com.vpm.service.DupService;
import com.vpm.service.FileService;

@Controller
public class DocumentController {
	@Autowired
	DocumentService documentService;
	@Autowired
	DupService dupService;
	@Autowired
	FileService fileservice;
	//添加父文件夹
	@RequestMapping(value="/addD",produces = {"application/json;charset=UTF-8"})
	public void addDocument(String d_name,int inherit,HttpServletResponse response) throws Exception {
		Document document = (Document) documentService.addDocument(d_name,inherit);
		String string3 = JSON.toJSONString(document);
		System.out.println("11111"+string3);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string3);
	}
	
	@RequestMapping(value="/deleteD",produces = {"application/json;charset=UTF-8"})
	public void deleteDocument(int d_id,int p_id,HttpSession session,HttpServletResponse response) throws Exception {
		int u_id =(int) session.getAttribute("u_id");
		int dd_id4 = d_id;
		System.out.println(u_id);
		System.out.println(d_id);
		System.out.println(p_id);
		List<Integer> iList = new ArrayList<>();
		while (documentService.findFaDocument(d_id).getInherit()==1) {
			iList.add(documentService.findFaDocument(d_id).getDd_id());//集合添加当前父文件夹ID30
			d_id=documentService.findFaDocument(d_id).getDd_id();
		}
		List<Dup> dups=dupService.findByUD(p_id,d_id,u_id);
		for (Integer d_id1 : iList) {
			List<Dup> dups2 = dupService.findByUD(p_id,d_id1,u_id);
			for (Dup dup : dups2) {
				dups.add(dup);
			}
		}
		System.out.println(dups);
		int i = dups.size();
		if (i==0) {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write("20");
		}
		else {
			List<Dup> dups2 = dupService.findDup(dd_id4);
			for (Dup dup : dups2) {
				dupService.deleteDup(dup);
			}
			Document document = documentService.findFaDocument(dd_id4);
			document.setDd_id(0);
			document.setInherit(3);
			documentService.addupdated(document);
			//documentService.deleteDocument(d_id);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write("30");
		}
	}
	//添加子文件夹
	@RequestMapping(value="/addDS",produces = {"application/json;charset=UTF-8"})
	public void addDocument(int dd_id,int p_id,int inherit,String d_name,HttpSession session,HttpServletResponse response) throws Exception {
	    int u_id =(int) session.getAttribute("u_id");
	    int dd_id3 = dd_id;
	    System.out.println(u_id);
		System.out.println(dd_id);
		System.out.println(p_id);
		List<Integer> iList = new ArrayList<>();
		while (documentService.findFaDocument(dd_id).getInherit()==1) {
			iList.add(documentService.findFaDocument(dd_id).getDd_id());//集合添加当前父文件夹ID30
			dd_id=documentService.findFaDocument(dd_id).getDd_id();
		}
		List<Dup> dups1=dupService.findByUD(p_id,dd_id,u_id);
		for (Integer d_id1 : iList) {
			List<Dup> dups2 = dupService.findByUD(p_id,d_id1,u_id);
			for (Dup dup : dups2) {
				dups1.add(dup);
			}
		}
//	    List<Dup> dups1=dupService.findByUD(p_id,dd_id,u_id);

		
		int i = dups1.size();
		System.out.println(i);
		if (i==0) {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write("20");
		}
		else {
			Document document = (Document) documentService.addDocumentSon(d_name, dd_id3,inherit);
			int d_id = document.getD_id();
			List<Dup> pList = dupService.findDup(dd_id);
			dupService.addDups(dd_id,document);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write("30");
		}
	}
	//查看所以父文件夹
	@RequestMapping(value="/findD",produces = {"application/json;charset=UTF-8"})
	public void findalldoc(HttpServletResponse response) throws IOException{
		List<Document> documents = documentService.findAllDocument();
		String string = JSON.toJSONString(documents);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string);
	}
	//查看子文件夹
	@RequestMapping(value="/findDs",produces = {"application/json;charset=UTF-8"})
	public void findalldocs(int dd_id,int p_id,HttpSession session,HttpServletResponse response) throws IOException{
		int u_id =(int) session.getAttribute("u_id");
	    int dd_id4= dd_id;
		System.out.println(u_id);
		System.out.println(dd_id);
		System.out.println(p_id);
		List<Integer> iList = new ArrayList<>();
		while (documentService.findFaDocument(dd_id).getInherit()==1) {
			iList.add(documentService.findFaDocument(dd_id).getDd_id());//集合添加当前父文件夹ID30
			dd_id=documentService.findFaDocument(dd_id).getDd_id();
		}
		List<Dup> dups=dupService.findByUD(p_id,dd_id,u_id);
		for (Integer d_id1 : iList) {
			List<Dup> dups2 = dupService.findByUD(p_id,d_id1,u_id);
			for (Dup dup : dups2) {
				dups.add(dup);
			}
		}
		System.out.println(dups);
		int i = dups.size();
	   // List<Dup> dups1=dupService.findByUD(p_id,dd_id,u_id);
		//int i = dups1.size();
		System.out.println(i);
		if (i==0) {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write("20");
		}
		else {
			List<Document> documents = documentService.findAllDocumentS(dd_id4);
			String string = JSON.toJSONString(documents);
			System.out.println("999999999"+string);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(string);
		}
	}
	
	@RequestMapping(value="/inherit",produces = {"application/json;charset=UTF-8"})
	public void updateInherit(int d_id,int inherit,HttpServletResponse response) throws IOException{
		Document document =  documentService.updateInherit(d_id,inherit);
		String string = JSON.toJSONString(document);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string);
	}
}
