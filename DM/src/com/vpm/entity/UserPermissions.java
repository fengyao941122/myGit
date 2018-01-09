package com.vpm.entity;

public class UserPermissions {
	
	private User user ;
	
	private Permissions permissions;

	public UserPermissions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPermissions(User user, Permissions permissions) {
		super();
		this.user = user;
		this.permissions = permissions;
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
	
	

}
