package com.revature.beans;

import java.io.Serializable;

public class RoleType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7877052733521207661L;
	private int roleId;
	private String roleName;

	public RoleType() {
		super();
	}

	public RoleType(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RoleType [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
}
