package com.vpm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "t_Dup")
public class Dup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer s_id;
	@ManyToOne
	//@Cascade(value = {CascadeType.DELETE})
	@JoinColumn(name="d_id")
	//@JSONField(serialize =false)
	private Document document;

	@ManyToOne
	//@Cascade(value = {CascadeType.DELETE})
	@JoinColumn(name="f_id")
	//@JSONField(serialize =false)
	private File file;
	
	@ManyToOne
	//@Cascade(value = {CascadeType.DELETE})
	@JoinColumn(name="u_id")
	//@JSONField(serialize =false)
	private User user;
	@ManyToOne
	//@Cascade(value = {CascadeType.DELETE})
	@JoinColumn(name="p_id")
	//@JSONField(serialize =false)
	private Permissions permissions ;
	public Dup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dup(Document document, User user, Permissions permissions) {
		super();
		this.document = document;
		this.user = user;
		this.permissions = permissions;
	}
	public Dup(File file, User user, Permissions permissions) {
		super();
		this.file = file;
		this.user = user;
		this.permissions = permissions;
	}
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Permissions getPermissions() {
		return permissions;
	}
	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}
	@Override
	public String toString() {
		return "Dup [s_id=" + s_id + ", document=" + document + ", file=" + file + ", user=" + user + ", permissions="
				+ permissions + "]";
	}
	
	

}
