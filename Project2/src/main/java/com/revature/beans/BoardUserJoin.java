package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BOARD_USER_JOIN")
public class BoardUserJoin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6838882239390588980L;
	
	@Id
	@ManyToOne
	@JoinColumn(name="BOARD_ID")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name="SU_ID")
	private ScrumUser scrumUser;

	public BoardUserJoin() {
		super();
	}

	public BoardUserJoin(Board board, ScrumUser scrumUser) {
		super();
		this.board = board;
		this.scrumUser = scrumUser;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public ScrumUser getScrumUser() {
		return scrumUser;
	}

	public void setScrumUser(ScrumUser scrumUser) {
		this.scrumUser = scrumUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BoardUserJoin [board=" + board + ", scrumUser=" + scrumUser + "]";
	}
}
