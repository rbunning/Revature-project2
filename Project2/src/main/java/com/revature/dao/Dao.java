package com.revature.dao;

import java.util.List;

import com.revature.beans.Board;
import com.revature.beans.ScrumUser;
import com.revature.beans.Task;

public interface Dao {

	public ScrumUser getScrumUserById(ScrumUser sUser);

	public ScrumUser getScrumUserByUsername(ScrumUser sUser);
	
	public Board addBoard(Board newBoard);
	
	public void addUserToBoard(Board board, ScrumUser sUser);
	
	public List<Board> getBoardList(ScrumUser sUser);

	public void createTask(Task t);

	public Task getTaskById(Task t);
}
