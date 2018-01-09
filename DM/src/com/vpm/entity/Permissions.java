package com.vpm.entity;
import java.util.Set;

import javax.persistence.Column;
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
@Table(name = "t_permissions")
public class Permissions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer p_id;
	@Column(name="permissions")
	private String permissions;
	public Permissions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Permissions(String permissions) {
		super();
		this.permissions = permissions;
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	@Override
	public String toString() {
		return "Permissions [p_id=" + p_id + ", permissions=" + permissions + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		 if(this == obj)  
		        return false;
		 if((obj == null) || (obj.getClass() != this.getClass()))  
			        return false;
		 Permissions permiss = (Permissions) obj;
		return p_id == permiss.p_id&&(permissions==permiss.permissions||(permissions!=null&&permissions.equals(permiss.permissions)));
	}
	
	@Override
	public int hashCode() {
		int hash = 7; 
		 hash = 31 * hash + p_id; 
		 hash = 31 * hash + (null == permissions ? 0 : permissions.hashCode());
		return  hash;
	}
}
