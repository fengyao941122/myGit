package com.vpm.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "t_Document")
public class Document {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer d_id;
	private Integer dd_id;
	private String d_name;
	private Integer inherit;
	@OneToMany(mappedBy="document",fetch=FetchType.EAGER)
	@Cascade(value = {CascadeType.DELETE})
	@JSONField(serialize =false)
	private Set<LeaveMessage> leaveMessages = new HashSet<LeaveMessage>();

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Document(Integer dd_id, String d_name) {
		super();
		this.dd_id = dd_id;
		this.d_name = d_name;
	}

	public Document(Integer dd_id, String d_name, Integer inherit) {
		super();
		this.dd_id = dd_id;
		this.d_name = d_name;
		this.inherit = inherit;
	}

	public Document(String d_name, Integer inherit) {
		super();
		this.d_name = d_name;
		this.inherit = inherit;
	}

	public Document(String d_name) {
		super();
		this.d_name = d_name;
	}

	public Integer getD_id() {
		return d_id;
	}

	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}

	public Integer getDd_id() {
		return dd_id;
	}

	public void setDd_id(Integer dd_id) {
		this.dd_id = dd_id;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public Set<LeaveMessage> getLeaveMessages() {
		return leaveMessages;
	}

	public void setLeaveMessages(Set<LeaveMessage> leaveMessages) {
		this.leaveMessages = leaveMessages;
	}

	public Integer getInherit() {
		return inherit;
	}

	public void setInherit(Integer inherit) {
		this.inherit = inherit;
	}



	

}
