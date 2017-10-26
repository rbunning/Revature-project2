package com.revature.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * 
 * @author jay
 *
 */

@Entity
@Table(name="CHART")
public class Chart implements Serializable {

	/**
	 * Chart 	table
	 * CHART_ID	column
	 * BOARD_ID	column
	 * CHART_TITLE	column
	 * START_DATE	column
	 * END_DATE		column
	 */
	private static final long serialVersionUID = 8410665221636520198L;
	
	@Id
	@Column(name="CHART_ID")
	@SequenceGenerator(allocationSize=1, sequenceName="CHART_SEQ", name="C_SEQ")
	@GeneratedValue(generator="C_SEQ", strategy=GenerationType.SEQUENCE)
	private int chartId;
	
	@ManyToOne
	@JoinColumn(name="BOARD_ID")
	private Board board;
	
	@Column(name="CHART_TITLE")
	private String chartTitle;
	@Column(name="START_DATE")
	private Date startDate;
	@Column(name="END_DATE")
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