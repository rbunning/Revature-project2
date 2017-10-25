package com.revature.beans;

import java.io.Serializable;
import java.sql.Date;
/**
 * 
 * @author jay
 *
 */
public class Chart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8410665221636520198L;

	private int chardId;
	private int boardId;
	private String chartTitle;
	private Date startDate;
	private Date endDate;
	
	public Chart() {
		super();
	}

	public Chart(int chardId, int boardId, String chartTitle, Date startDate, Date endDate) {
		super();
		this.chardId = chardId;
		this.boardId = boardId;
		this.chartTitle = chartTitle;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getChardId() {
		return chardId;
	}

	public void setChardId(int chardId) {
		this.chardId = chardId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getChartTitle() {
		return chartTitle;
	}

	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Chart [chardId=" + chardId + ", boardId=" + boardId + ", chartTitle=" + chartTitle + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
}
