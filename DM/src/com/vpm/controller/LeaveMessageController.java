package com.vpm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.vpm.entity.LeaveMessage;
import com.vpm.service.DocumentService;
import com.vpm.service.LeaveMessageService;

@Controller

public class LeaveMessageController {
	@Autowired
	LeaveMessageService leaveMessageService;
	@Autowired
	DocumentService documentService;

	@RequestMapping("/indexL")
	public String index() {
		return "index3";
	}

	// addL?d_id=48&l_content=rew
	@RequestMapping(value = "/addLD", produces = { "application/json;charset=UTF-8" })
	public void addLeaveMessage(int d_id, String l_content, HttpServletResponse response) throws IOException {

		// Integer d_id = Integer.valueOf(string3);
		System.out.println(d_id);
		System.out.println(l_content);
		LeaveMessage leaveMessage = (LeaveMessage) leaveMessageService.addLeaveMessage(d_id, l_content);
		String string2 = JSON.toJSONString(leaveMessage);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string2);
	}

	@RequestMapping(value = "/addLF", produces = { "application/json;charset=UTF-8" })
	public void addLeaveMessageFile(int f_id, String l_content, HttpServletResponse response) throws IOException {

		// Integer d_id = Integer.valueOf(string3);
		System.out.println(f_id);
		System.out.println(l_content);
		LeaveMessage leaveMessage = (LeaveMessage) leaveMessageService.addLeaveMessageFile(f_id, l_content);
		String string2 = JSON.toJSONString(leaveMessage);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string2);
	}
	
	// delL?l_id=70
	@RequestMapping(value = "/delL", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String delete(int l_id) {
		return "删除结果" + leaveMessageService.deleteLeaveMessage(l_id);
	}

	@RequestMapping(value = "/findl", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public void findById(int d_id, HttpServletResponse response) throws IOException {
		List<LeaveMessage> leaveMessages = leaveMessageService.findLeaveMessage(d_id);
		String string = JSON.toJSONString(leaveMessages,SerializerFeature.DisableCircularReferenceDetect);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string);
	}
	@RequestMapping(value = "/findlf", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public void findByIdf(int f_id, HttpServletResponse response) throws IOException {
		List<LeaveMessage> leaveMessages = leaveMessageService.findLeaveMessagefile(f_id);
		String string = JSON.toJSONString(leaveMessages,SerializerFeature.DisableCircularReferenceDetect);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string);
	}
	
	@RequestMapping(value = "/updateL", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public void updateLeaveMessage(int d_id, int l_id, String l_content, HttpServletResponse response)
			throws IOException {
		LeaveMessage leaveMessage = (LeaveMessage) leaveMessageService.updateLeaveMessage(d_id, l_id, l_content);
		String string2 = JSON.toJSONString(leaveMessage);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(string2);

	}

}
