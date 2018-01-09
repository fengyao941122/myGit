package com.vpm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.org.apache.regexp.internal.recompile;
import com.vpm.dao.DocumentDao;
import com.vpm.dao.FileDao;
import com.vpm.dao.LeaveMessageDao;
import com.vpm.entity.Document;
import com.vpm.entity.File;
import com.vpm.entity.LeaveMessage;
import com.vpm.service.LeaveMessageService;
@Service
public class LeaveMessageServiceImpl implements LeaveMessageService {
	@Autowired
	LeaveMessageDao leaveMessageDao;
	@Autowired
	DocumentDao documentdao;
	@Autowired
	FileDao filedao;

	@Override
	public Object addLeaveMessage(int d_id, String l_content) {
           Document document=(Document) documentdao.findById(d_id);
           LeaveMessage leaveMessage = new LeaveMessage(l_content, document);
		   leaveMessageDao.addLeaveMessage(leaveMessage);
           return leaveMessage;
	}

	@Override
	public Boolean deleteLeaveMessage(int l_id) {
		LeaveMessage leaveMessage=(LeaveMessage) leaveMessageDao.findById(l_id);
		if(leaveMessage==null)
			return false;
		leaveMessageDao.deleteLeaveMessage(leaveMessage);
		return true;
	}

	@Override
	public List<LeaveMessage> findLeaveMessage(int d_id) {
//		String rString = "";
//		List<LeaveMessage> leaveMessages = (List<LeaveMessage>) leaveMessageDao.findByDid(d_id);
//		for (LeaveMessage leaveMessage : leaveMessages) {
//			rString+= leaveMessage;
//		}
		return (List<LeaveMessage>) leaveMessageDao.findByDid(d_id);
	}

	@Override
	public Object updateLeaveMessage(int d_id,int l_id,String l_content) {
		Document document=(Document) documentdao.findById(d_id);
		LeaveMessage leaveMessage1 = (LeaveMessage) leaveMessageDao.findById(l_id);
		leaveMessage1.setL_content(l_content);
        //LeaveMessage leaveMessage = new LeaveMessage(l_id,l_content, document);
		leaveMessageDao.updateLeaveMessage(leaveMessage1);
        return leaveMessage1;
	}

	@Override
	public Object addLeaveMessageFile(int f_id, String l_content) {
		File file = (File) filedao.findById(f_id);
		LeaveMessage leaveMessage = new LeaveMessage(l_content, file);
		leaveMessageDao.addLeaveMessage(leaveMessage);
		return leaveMessage;
	}

	@Override
	public List<LeaveMessage> findLeaveMessagefile(int f_id) {
		
		return (List<LeaveMessage>) leaveMessageDao.findbyfid(f_id);
	}


}
