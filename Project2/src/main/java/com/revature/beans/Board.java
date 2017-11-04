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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "BOARD")
public class Board implements Serializable {

	private static final long serialVersionUID = -4064729888746010349L;

	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
	private Set<Story> story = new HashSet<Story>();
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "BOARD_USER_JOIN", joinColumns = @JoinColumn(name = "board_id", referencedColumnName = "board_id"), inverseJoinColumns = @JoinColumn(name = "su_id", referencedColumnName = "su_id"))
	private Set<ScrumUser> scrumUsers;

	@Id
	@Column(name = "BOARD_ID")
	@SequenceGenerator(name = "boardSeq", sequenceName = "board_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boardSeq")
	private int boardId;
	@Column(name = "BOARD_NAME")
	private String boardName;

	public Board() {
		super();
	}

	public Board(String boardName) {
		super();
		this.boardName = boardName;
	}

	public Board(int boardId) {
		super();
		this.boardId = boardId;
	}

	public Board(int boardId, String boardName) {
		super();
		this.boardId = boardId;
		this.boardName = boardName;
	}

	public Set<Story> getStory() {
		return story;
	}

	public void setStory(Set<Story> story) {
		this.story = story;
	}

	public Set<ScrumUser> getScrumUsers() {
		return scrumUsers;
	}

	public void setScrumUsers(Set<ScrumUser> scrumUsers) {
		this.scrumUsers = scrumUsers;
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