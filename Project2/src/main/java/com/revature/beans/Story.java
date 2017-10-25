package com.revature.beans;

import java.io.Serializable;
/**
 * 
 * @author jay
 *
 */
import java.sql.Date;

import com.revature.exceptions.InvalidLaneTypeException;
public class Story implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3437652641718304355L;
	
	private Story story;
	private Board board;
	private LaneType laneType;
	private String storyName;
	private int storyPoints;
	private String storyDesc;
	private Date lastMoveDate;
	
	public Story() {
		super();
	}

	public Story(Story story, Board board, LaneType laneType, String storyName, int storyPoints, String storyDesc,
			Date lastMoveDate) {
		super();
		this.story = story;
		this.board = board;
		this.laneType = laneType;
		this.storyName = storyName;
		this.storyPoints = storyPoints;
		this.storyDesc = storyDesc;
		this.lastMoveDate = lastMoveDate;
	}

	
	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public LaneType getLaneType() {
		return laneType;
	}

	public void setLaneType(LaneType laneType) {
		this.laneType = laneType;
	}

	public String getStoryName() {
		return storyName;
	}

	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}

	public int getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
	}

	public String getStoryDesc() {
		return storyDesc;
	}

	public void setStoryDesc(String storyDesc) {
		this.storyDesc = storyDesc;
	}

	public Date getLastMoveDate() {
		return lastMoveDate;
	}

	public void setLastMoveDate(Date lastMoveDate) {
		this.lastMoveDate = lastMoveDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Story [storyId=" + story + ", boardId=" + board + ", laneId=" + laneType + ", storyName=" + storyName
				+ ", storyPoints=" + storyPoints + ", storyDesc=" + storyDesc + ", lastMoveDate=" + lastMoveDate + "]";
	}
}
