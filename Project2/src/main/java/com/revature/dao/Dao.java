package com.revature.dao;

import com.revature.beans.Board;
import com.revature.beans.ScrumUser;
import com.revature.beans.Story;
import com.revature.beans.Task;

public interface Dao {

	// CREATE
	public Board addBoard(Board newBoard);

	public void addUserToBoard(Board board, ScrumUser sUser);
	
	public void createTask(Task t);
	
	public void createStory(Story story);

	// READ
	public ScrumUser getScrumUserById(ScrumUser sUser);

	public ScrumUser getScrumUserByUsername(ScrumUser sUser);

	public Task getTaskById(Task t);
	
	// UPDATE

	// DELETE
}
