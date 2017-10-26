package com.revature.beans;

import java.io.Serializable;

public class UserComment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6633221483595409897L;

	private int userComment;
	private Story story;
	private ScrumUser scrumUser;
	private String ChartTitle;
	private String UserCommentDate;

	public UserComment() {
		super();
	}

	public UserComment(int userComment, Story story, ScrumUser scrumUser, String chartTitle, String userCommentDate) {
		super();
		this.userComment = userComment;
		this.story = story;
		this.scrumUser = scrumUser;
		ChartTitle = chartTitle;
		UserCommentDate = userCommentDate;
	}

	public int getUserComment() {
		return userComment;
	}

	public void setUserComment(int userComment) {
		this.userComment = userComment;
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
		return "UserComment [userComment=" + userComment + ", story=" + story + ", scrumUser=" + scrumUser
				+ ", ChartTitle=" + ChartTitle + ", UserCommentDate=" + UserCommentDate + "]";
	}

}
