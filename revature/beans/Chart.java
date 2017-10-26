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

	private int chartId;
	private Board board;
	private String chartTitle;
	private Date startDate;
	private Date endDate;
	
	public Chart() {
		super();
	}

	public Chart(int chardId, Board board, String chartTitle, Date startDate, Date endDate) {
		super();
		this.chartId = chardId;
		this.board = board;
		this.chartTitle = chartTitle;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getChardId() {
		return chartId;
	}

	public void setChardId(int chardId) {
		this.chartId = chardId;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoardId(Board board) {
		this.board = board;
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
		return "Chart [chardId=" + chartId + ", boardId=" + board + ", chartTitle=" + chartTitle + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
}
