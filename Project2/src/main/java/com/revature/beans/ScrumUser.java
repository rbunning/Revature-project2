package com.revature.beans;

import java.io.Serializable;

public class ScrumUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1738765309975039165L;
	private int scrumUserId;
	private RoleType roleType;
	private String scrumUserFirstname;
	private String scrumUserLastname;
	private String scrumUserUsername;
	private String scrumUserPassword;

	public ScrumUser() {
		super();
	}

	public ScrumUser(int scrumUerId, RoleType roleType, String scrumUserFirstname, String scrumUserLastname,
			String scrumUserUsername, String scrumUserPassword) {
		super();
		this.scrumUserId = scrumUerId;
		this.roleType = roleType;
		this.scrumUserFirstname = scrumUserFirstname;
		this.scrumUserLastname = scrumUserLastname;
		this.scrumUserUsername = scrumUserUsername;
		this.scrumUserPassword = scrumUserPassword;
	}

	public int getScrumUerId() {
		return scrumUserId;
	}

	public void setScrumUerId(int scrumUerId) {
		this.scrumUserId = scrumUerId;
	}

	public RoleType getRoleId() {
		return roleType;
	}

	public void setRoleId(RoleType roleId) {
		this.roleType = roleId;
	}

	public String getScrumUserFirstname() {
		return scrumUserFirstname;
	}

	public void setScrumUserFirstname(String scrumUserFirstname) {
		this.scrumUserFirstname = scrumUserFirstname;
	}

	public String getScrumUserLastname() {
		return scrumUserLastname;
	}

	public void setScrumUserLastname(String scrumUserLastname) {
		this.scrumUserLastname = scrumUserLastname;
	}

	public String getScrumUserUsername() {
		return scrumUserUsername;
	}

	public void setScrumUserUsername(String scrumUserUsername) {
		this.scrumUserUsername = scrumUserUsername;
	}

	public String getScrumUserPassword() {
		return scrumUserPassword;
	}

	public void setScrumUserPassword(String scrumUserPassword) {
		this.scrumUserPassword = scrumUserPassword;
	}

	@Override
	public String toString() {
		return "ScrumUser [scrumUerId=" + scrumUserId + ", RoleId=" + roleType + ", scrumUserFirstname="
				+ scrumUserFirstname + ", scrumUserLastname=" + scrumUserLastname + ", scrumUserUsername="
				+ scrumUserUsername + ", scrumUserPassword=" + scrumUserPassword + "]";
	}
}
