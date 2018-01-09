package com.vpm.controller;

import java.io.File;
import java.io.IOException;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;
import com.vpm.entity.Document;
import com.vpm.entity.Dup;
import com.vpm.service.DupService;
import com.vpm.service.FileService;

@Controller
public class FileController {
	
	@Autowired
	FileService fileservice;
	@Autowired
	DupService dupService;
	@RequestMapping(value="/addFile",produces = {"application/json;charset=UTF-8"})
	public void addFile(com.vpm.entity.File files,int inherit,int p_id,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws Exception {
		String d_id1 = request.getParameter("d_id");
		int d_id2 = 	Integer.parseInt(d_id1);
		int u_id1 =(int) session.getAttribute("u_id");
		System.out.println(u_id1);
		System.out.println(d_id1);
		System.out.println(p_id);
		List<Dup> dups1=dupService.findByUD(p_id,d_id2,u_id1);
		int i1 = dups1.size();
		if (i1==0) {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write("20");
		}
		else {
			 // 这是原来的文件名，如果有更新，则这个名称会下面的代码中做出更改
		     String newImageFileName="";
		     File localFile = new File("");
				//URLDecoder.decode(request.getParameter("goods_pic_name"),"utf-8");
			CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
			if(multipartResolver.isMultipart(request)){
				MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest) request;
				Iterator<String> iter=multiRequest.getFileNames();
				while(iter.hasNext()){
					MultipartFile file=multiRequest.getFile(iter.next());
					if(file!=null){
						// 取得当前上传文件的名称
						String currFileName=file.getOriginalFilename();
						if(currFileName.trim()!=""){
							String imgPath=ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
							System.out.println(imgPath);
							// 重命名上传后的文件名
							newImageFileName=UUID.randomUUID() + currFileName.substring(currFileName.lastIndexOf("."));
							System.out.println(newImageFileName);
							localFile=new File(imgPath + "/upload/image/", newImageFileName);
							// 向服务器上传输文件
							System.out.println(localFile);
							file.transferTo(localFile);
				}
			}
		}
	}
		int d_id = 	Integer.parseInt(d_id1);
		String f_name = newImageFileName;
		String  f_url = localFile.toString();
		com.vpm.entity.File file = (com.vpm.entity.File) fileservice.addFile(d_id, inherit,f_name,f_url);
		int f_id = file.getF_id();
		List<Dup> pList = dupService.findDup(d_id);
		dupService.addDupsf(d_id,file);
		String string = JSON.toJSONString(file);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write("30");
		}

	}
	
	
	//删除文件
	@RequestMapping(value="/deleteFile",produces = {"application/json;charset=UTF-8"})
	public void deleteFile(int f_id,HttpServletResponse response) throws IOException{
		fileservice.deleteFile(f_id);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write("");
	}
	
	//显示文件
	@RequestMapping(value="/findFile",produces = {"application/json;charset=UTF-8"})
	public void findFile(int dd_id,HttpServletResponse response) throws IOException{
		List<com.vpm.entity.File> files = fileservice.findallFile(dd_id);
		String string = JSON.toJSONString(files);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string);
	}
	//设置继承
	@RequestMapping(value="/inheritf",produces = {"application/json;charset=UTF-8"})
	public void updateInheritf(int f_id,int inherit,HttpServletResponse response) throws IOException{
		com.vpm.entity.File file =  fileservice.updateInherit(f_id,inherit);
		String string = JSON.toJSONString(file);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string);
	}
}
