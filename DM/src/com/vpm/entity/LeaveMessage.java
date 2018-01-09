package com.vpm.entity;
//留言类
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "t_LeaveMessage")
public class LeaveMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer l_id;
	
	private String l_content;
	@ManyToOne
	@Cascade(value = {CascadeType.DELETE})
	@JoinColumn(name="d_id")
	private Document document;
	
	@ManyToOne
	@Cascade(value = {CascadeType.DELETE})
	@JoinColumn(name="f_id")
	private File file;

	public LeaveMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeaveMessage(String l_content, Document document) {
		super();
		this.l_content = l_content;
		this.document = document;
	}

	public LeaveMessage(String l_content, File file) {
		super();
		this.l_content = l_content;
		this.file = file;
	}

	public Integer getL_id() {
		return l_id;
	}

	public void setL_id(Integer l_id) {
		this.l_id = l_id;
	}

	public String getL_content() {
		return l_content;
	}

	public void setL_content(String l_content) {
		this.l_content = l_content;
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



	
	
	
}
