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
	
	private int storyId;
	private int boardId;
	private int lnId;
	
	/*
	 * A enum type that verifies our lane type using singleton DP
	 */
	private enum lnName {
		BACKLOG(1), TODO(2), INPROGRESS(3), TEST(4), VERIFY(5), DONE(6);
		private final int value;
		private 	lnName(int value) {
			this.value = value;
		}
		
		public int getType() {
			return value;
		}
	};
	
	private String storyName;
	private int storyPoints;
	private String storyDesc;
	private Date lastMoveDate;
	
	public Story() {
		super();
	}

	public Story(int storyId, int boardId, int laneId, String storyName, int storyPoints, String storyDesc, Date lastMoveDate) {
		super();
		this.storyId = storyId;
		this.boardId = boardId;
		
		try {
			switch(laneId) {
			case 1:
				this.lnId = lnName.BACKLOG.getType();
				break;
			case 2:
				this.lnId = lnName.TODO.getType();
				break;
			case 3:
				this.lnId = lnName.INPROGRESS.getType();
				break;
			case 4:
				this.lnId = lnName.TEST.getType();
				break;
			case 5:
				this.lnId = lnName.VERIFY.getType();
				break;
			case 6:
				this.lnId = lnName.DONE.getType();
				break;
			default:
				throw new InvalidLaneTypeException();
		} 
		} catch (InvalidLaneTypeException e) {
			e.printStackTrace();
		}
		
		this.storyName = storyName;
		this.storyPoints = storyPoints;
		this.storyDesc = storyDesc;
		this.lastMoveDate = lastMoveDate;
	}

	public int getStoryId() {
		return storyId;
	}

	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getLaneId() {
		return lnId;
	}

	public void setLaneId(int laneId) {
		this.lnId = laneId;
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
		return "Story [storyId=" + storyId + ", boardId=" + boardId + ", laneId=" + lnId + ", storyName=" + storyName
				+ ", storyPoints=" + storyPoints + ", storyDesc=" + storyDesc + ", lastMoveDate=" + lastMoveDate + "]";
	}
}
