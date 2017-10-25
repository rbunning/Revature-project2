package com.revature.beans;

public class ScrumUser {

	private int scrumUerId;
	private RoleType RoleId;
	private String scrumUserFirstname;
	private String scrumUserLastname;
	private String scrumUserUsername;
	private String scrumUserPassword;

	public ScrumUser() {
		super();
	}

	public ScrumUser(int scrumUerId, RoleType roleId, String scrumUserFirstname, String scrumUserLastname,
			String scrumUserUsername, String scrumUserPassword) {
		super();
		this.scrumUerId = scrumUerId;
		RoleId = roleId;
		this.scrumUserFirstname = scrumUserFirstname;
		this.scrumUserLastname = scrumUserLastname;
		this.scrumUserUsername = scrumUserUsername;
		this.scrumUserPassword = scrumUserPassword;
	}

	public int getScrumUerId() {
		return scrumUerId;
	}

	public void setScrumUerId(int scrumUerId) {
		this.scrumUerId = scrumUerId;
	}

	public RoleType getRoleId() {
		return RoleId;
	}

	public void setRoleId(RoleType roleId) {
		RoleId = roleId;
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
		return "ScrumUser [scrumUerId=" + scrumUerId + ", RoleId=" + RoleId + ", scrumUserFirstname="
				+ scrumUserFirstname + ", scrumUserLastname=" + scrumUserLastname + ", scrumUserUsername="
				+ scrumUserUsername + ", scrumUserPassword=" + scrumUserPassword + "]";
	}
}
