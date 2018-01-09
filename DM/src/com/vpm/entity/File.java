package com.vpm.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "t_File")
public class File {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer f_id;
	private Integer dd_id;
	private String f_name;
	private String  f_url;
	private Integer inherit;
	@OneToMany(mappedBy="file",fetch=FetchType.EAGER)
	@Cascade(value = {CascadeType.DELETE})
	private Set<LeaveMessage> leaveMessages = new HashSet<LeaveMessage>();
	
	public File() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public File(Integer dd_id, String f_name, String f_url2) {
		super();
		this.dd_id = dd_id;
		this.f_name = f_name;
		this.setF_url(f_url2);
	}

	public File(Integer dd_id, String f_name, String f_url, Integer inherit) {
		super();
		this.dd_id = dd_id;
		this.f_name = f_name;
		this.f_url = f_url;
		this.inherit = inherit;
	}

	public File(Integer dd_id, String f_name) {
		super();
		this.dd_id = dd_id;
		this.f_name = f_name;
	}
	public Integer getF_id() {
		return f_id;
	}
	public void setF_id(Integer f_id) {
		this.f_id = f_id;
	}
	public Integer getDd_id() {
		return dd_id;
	}
	public void setDd_id(Integer dd_id) {
		this.dd_id = dd_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	@Override
	public String toString() {
		return "File [f_id=" + f_id + ", dd_id=" + dd_id + ", f_name=" + f_name + "]";
	}

	public String getF_url() {
		return f_url;
	}

	public void setF_url(String f_url) {
		this.f_url = f_url;
	}

	public Integer getInherit() {
		return inherit;
	}

	public void setInherit(Integer inherit) {
		this.inherit = inherit;
	}
	
}
