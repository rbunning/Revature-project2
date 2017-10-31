package com.revature.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BOARD")
public class Board implements Serializable {

	private static final long serialVersionUID = -4064729888746010349L;

	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) 
	Set<Story> story = new HashSet<Story>(); 	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) 
	Set<BoardUserJoin> boardUserJoin = new HashSet<BoardUserJoin>(); 	
	
	@Id
	@Column(name="BOARD_ID")
	@SequenceGenerator(name="boardSeq",sequenceName="board_seq", allocationSize=1)        
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="boardSeq") 
	private int boardId;
	@Column(name="BOARD_NAME")
	private String boardName;
	
	public Board() {
		super();
	}

	public Board(String boardName) {
		super();
		this.boardName = boardName;
	}

	public Board(int boardId, String boardName) {
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

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
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