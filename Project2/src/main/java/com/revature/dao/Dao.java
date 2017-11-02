package com.revature.dao;

import java.util.List;

import com.revature.beans.Board;
import com.revature.beans.ScrumUser;
import com.revature.beans.Story;
import com.revature.beans.Task;

public interface Dao {

	// CREATE
	public Board createBoard(Board newBoard);

	public void createUserToBoard(Board board, ScrumUser sUser);

	public void createTask(Task t);
	
	public void createStory(Story s);

	// READ
	public ScrumUser getScrumUserById(ScrumUser sUser);

	public ScrumUser getScrumUserByUsername(ScrumUser sUser);

	public Task getTaskById(Task t);
  
  public List<Board> getBoardList(ScrumUser sUser);
  
	// UPDATE

	// DELETE

}
