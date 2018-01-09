package com.vpm.dao;

import java.util.List;

import com.vpm.entity.LeaveMessage;

public interface LeaveMessageDao {
	
	public void addLeaveMessage(Object entity);
	
	public List<LeaveMessage> findLeaveMessage();
	
	public void deleteLeaveMessage(Object entity);
    Object findById(int l_id);
    Object findByDid(int d_id);

	public void updateLeaveMessage(Object entity);

    Object findbyfid(int f_id);
}
