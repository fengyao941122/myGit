package com.vpm.service;

import java.util.List;

import com.vpm.entity.LeaveMessage;

public interface LeaveMessageService {
	
	Object addLeaveMessage(int d_id,String l_content);
	
	Boolean deleteLeaveMessage(int l_id);
	
	public List<LeaveMessage> findLeaveMessage(int d_id);

	Object updateLeaveMessage(int d_id, int l_id, String l_content);

	Object addLeaveMessageFile(int f_id, String l_content);

	List<LeaveMessage> findLeaveMessagefile(int f_id);

}
