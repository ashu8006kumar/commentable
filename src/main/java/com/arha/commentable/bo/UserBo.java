package com.arha.commentable.bo;

import java.util.List;

import com.arha.commentable.datatype.RoleValue;

public class UserBo {
	private Long id;
	private String email;
	private String name;
	private List<RoleValue> userRoles;
	private boolean enabled = true;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<RoleValue> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<RoleValue> userRoles) {
		this.userRoles = userRoles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
