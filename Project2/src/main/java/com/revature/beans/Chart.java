package com.revature.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CHART")
public class Chart implements Serializable {

	private static final long serialVersionUID = 8410665221636520198L;
	
	@Id
	@Column(name="CHART_ID")
	@SequenceGenerator(allocationSize=1, sequenceName="CHART_SEQ", name="C_SEQ")
	@GeneratedValue(generator="C_SEQ", strategy=GenerationType.SEQUENCE)
	private int chartId;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="BOARD_ID")
	private Board board;
	
	@Column(name="CHART_TITLE")
	private String chartTitle;
	@Column(name="START_DATE")
	private Date startDate;
	
	public Chart() {
		super();
	}

	public Chart(int chardId, Board board, String chartTitle, Date startDate) {
		super();
		this.chartId = chardId;
		this.board = board;
		this.chartTitle = chartTitle;
		this.startDate = startDate;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Chart [chardId=" + chartId + ", boardId=" + board + ", chartTitle=" + chartTitle + ", startDate="
				+ startDate + "]";
	}
}