package com.vpm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer u_id;

	private String u_name;

	private String u_pword;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String u_name, String u_pword) {
		super();
		this.u_name = u_name;
		this.u_pword = u_pword;
	}

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_pword() {
		return u_pword;
	}

	public void setU_pword(String u_pword) {
		this.u_pword = u_pword;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_name=" + u_name + ", u_pword=" + u_pword + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		 if(this == obj)  
		        return false;
		 if((obj == null) || (obj.getClass() != this.getClass()))  
			        return false;
		 User user = (User) obj;
		return u_id == user.u_id&&(u_name==user.u_name||(u_name!=null&&u_name.equals(user.u_name)));
				
	}
	
	@Override
	public int hashCode() {
		int hash = 7; 
		 hash = 31 * hash + u_id; 
		 hash = 31 * hash + (null == u_name ? 0 : u_name.hashCode());
		return  hash;
	}
	
}
