package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="USER_COMMENT")
public class UserComment implements Serializable {

	/**
	 * USER_COMMENT -table
	 * UC_ID -column
	 * STORY_ID -column
	 * SU_ID -column
	 * CHART_TITLE -column
	 * UC_DATE -column
	 */
	private static final long serialVersionUID = 6633221483595409897L;

	@Id
	@Column(name="UC_ID")
	@SequenceGenerator(allocationSize=1, sequenceName = "USER_COMMENT_SEQ", name = "UC_SEQ" )
	@GeneratedValue(generator = "UC_SEQ", strategy = GenerationType.SEQUENCE)
	private int userCommentId;
	
	@ManyToOne
	@JoinColumn(name="STORY_ID")
	private Story story;
	
	@ManyToOne
	@JoinColumn(name="SU_ID")
	private ScrumUser scrumUser;
	
	@Column(name="CHART_TITLE")
	private String ChartTitle;
	
	@Column(name="UC_DATE")
	private String UserCommentDate;

	public UserComment() {
		super();
	}

	public UserComment(int userComment, Story story, ScrumUser scrumUser, String chartTitle, String userCommentDate) {
		super();
		this.userCommentId = userComment;
		this.story = story;
		this.scrumUser = scrumUser;
		ChartTitle = chartTitle;
		UserCommentDate = userCommentDate;
	}

	public int getUserComment() {
		return userCommentId;
	}

	public void setUserComment(int userComment) {
		this.userCommentId = userComment;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public ScrumUser getScrumUser() {
		return scrumUser;
	}

	public void setScrumUser(ScrumUser scrumUser) {
		this.scrumUser = scrumUser;
	}

	public String getChartTitle() {
		return ChartTitle;
	}

	public void setChartTitle(String chartTitle) {
		ChartTitle = chartTitle;
	}

	public String getUserCommentDate() {
		return UserCommentDate;
	}

	public void setUserCommentDate(String userCommentDate) {
		UserCommentDate = userCommentDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserComment [userComment=" + userCommentId + ", story=" + story + ", scrumUser=" + scrumUser
				+ ", ChartTitle=" + ChartTitle + ", UserCommentDate=" + UserCommentDate + "]";
	}

}
