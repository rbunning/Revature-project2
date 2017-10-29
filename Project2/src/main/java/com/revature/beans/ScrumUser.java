package com.revature.beans;

import java.io.Serializable;
import java.util.HashSet;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SCRUM_USER")
public class ScrumUser implements Serializable {

	private static final long serialVersionUID = -1738765309975039165L;
	@OneToMany(mappedBy = "scrumUser", fetch = FetchType.EAGER) 
	Set<BoardUserJoin> boardUserJoin = new HashSet<BoardUserJoin>(); 	
	
	@Id
	@Column(name="SU_ID")
	@SequenceGenerator(allocationSize=1, sequenceName = "SCRUM_USER_SEQ", name = "SU_SEQ" )
	@GeneratedValue(generator = "SU_SEQ", strategy = GenerationType.SEQUENCE)
	private int scrumUserId;
	
	@ManyToOne
	@JoinColumn(name="RT_ID")
	private RoleType roleType;
	
	@Column(name="SU_FN")
	private String scrumUserFirstname;
	
	@Column(name="SU_LN")
	private String scrumUserLastname;

	@Column(name="SU_USERNAME")
	private String scrumUserUsername;
	
	@Column(name="SU_PASSWORD")
	private String scrumUserPassword;

	public ScrumUser() {
		super();
	}

	public ScrumUser(String scrumUserUsername, String scrumUserPassword) {
		super();
		this.scrumUserUsername = scrumUserUsername;
		this.scrumUserPassword = scrumUserPassword;
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
		return "ScrumUser [scrumUerId=" + scrumUserId + ", RoleId=" + roleType + ", scrumUserFirstname="
				+ scrumUserFirstname + ", scrumUserLastname=" + scrumUserLastname + ", scrumUserUsername="
				+ scrumUserUsername + ", scrumUserPassword=" + scrumUserPassword + "]";
	}
}
