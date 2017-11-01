package com.revature.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SCRUM_USER")
public class ScrumUser implements Serializable {

	private static final long serialVersionUID = -1738765309975039165L;
	@ManyToMany
	@JoinTable(name = "BOARD_USER_JOIN", joinColumns = @JoinColumn(name = "su_id", referencedColumnName = "su_id"), inverseJoinColumns = @JoinColumn(name = "board_id", referencedColumnName = "board_id"))
	private Set<Board> boards;

	public Set<Board> getBoards() {
		return boards;
	}

	public void setBoards(Set<Board> boards) {
		this.boards = boards;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	@Id
	@Column(name = "SU_ID")
	@SequenceGenerator(allocationSize = 1, sequenceName = "SCRUM_USER_SEQ", name = "SU_SEQ")
	@GeneratedValue(generator = "SU_SEQ", strategy = GenerationType.SEQUENCE)
	private int scrumUserId;

	@ManyToOne
	@JoinColumn(name = "RT_ID")
	private RoleType roleType;

	@Column(name = "SU_FN")
	private String scrumUserFirstname;

	@Column(name = "SU_LN")
	private String scrumUserLastname;

	@Column(name = "SU_USERNAME")
	private String scrumUserUsername;

	@Column(name = "SU_PASSWORD")
	private String scrumUserPassword;

	public ScrumUser() {
		super();
	}

	public ScrumUser(String scrumUserUsername, String scrumUserPassword) {
		super();
		this.scrumUserUsername = scrumUserUsername.trim();
		this.scrumUserPassword = scrumUserPassword.trim();
	}

	public ScrumUser(int scrumUserId, RoleType roleType, String scrumUserFirstname, String scrumUserLastname,
			String scrumUserUsername, String scrumUserPassword) {
		super();
		this.scrumUserId = scrumUserId;
		this.roleType = roleType;
		this.scrumUserFirstname = scrumUserFirstname;
		this.scrumUserLastname = scrumUserLastname;
		this.scrumUserUsername = scrumUserUsername;
		this.scrumUserPassword = scrumUserPassword;
	}

	public int getScrumUserId() {
		return scrumUserId;
	}

	public void setScrumUserId(int scrumUserId) {
		this.scrumUserId = scrumUserId;
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
		return "ScrumUser [scrumUserId=" + scrumUserId + ", RoleId=" + roleType + ", scrumUserFirstname="
				+ scrumUserFirstname + ", scrumUserLastname=" + scrumUserLastname + ", scrumUserUsername="
				+ scrumUserUsername + ", scrumUserPassword=" + scrumUserPassword + "]";
	}
}
