package com.revature.beans;

import java.io.Serializable;

/**
 * 
 * @author jay
 *
 */
public class Board implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4064729888746010349L;

	
	private int boardId;
	private int boardName;
	
	public Board() {
		super();
	}

	public Board(int boardId, int boardName) {
		super();
		this.boardId = boardId;
		this.boardName = boardName;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getBoardName() {
		return boardName;
	}

	public void setBoardName(int boardName) {
		this.boardName = boardName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", boardName=" + boardName + "]";
	}
}
