package com.revature.beans;

import java.io.Serializable;
/**
 * 
 * @author jay
 *
 */
import java.sql.Date;
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
@Table(name="STORY")
public class Story implements Serializable {

	private static final long serialVersionUID = 3437652641718304355L;
	@OneToMany(mappedBy = "story", fetch = FetchType.EAGER) 
	Set<Task> task = new HashSet<Task>(); 	

	@Id
	@Column(name="STORY_ID")
	@SequenceGenerator(name="storySeq",sequenceName="story_seq", allocationSize=1)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="storySeq") 
	private int storyId;
	@ManyToOne
	@JoinColumn(name = "BOARD_ID")
	private Board board;
	@ManyToOne
	@JoinColumn(name = "LT_ID")
	private LaneType laneType;
	@Column(name="STORY_NAME")
	private String storyName;
	@Column(name="STORY_POINTS")
	private int storyPoints;
	@Column(name="STORY_DESC")
	private String storyDesc;
	@Column(name="LAST_MOVE_DATE")
	private Date lastMoveDate;

	public Story() {
		super();
	}

	public Story(int storyId, Board board, LaneType laneType, String storyName, int storyPoints, String storyDesc,
			Date lastMoveDate) {
		super();
		this.storyId = storyId;
		this.board = board;
		this.laneType = laneType;
		this.storyName = storyName;
		this.storyPoints = storyPoints;
		this.storyDesc = storyDesc;
		this.lastMoveDate = lastMoveDate;
	}

	public int getStory() {
		return storyId;
	}

	public void setStory(int storyId) {
		this.storyId = storyId;
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
		return "Story [storyId=" + storyId + ", boardId=" + board + ", laneId=" + laneType + ", storyName=" + storyName
				+ ", storyPoints=" + storyPoints + ", storyDesc=" + storyDesc + ", lastMoveDate=" + lastMoveDate + "]";
	}
}