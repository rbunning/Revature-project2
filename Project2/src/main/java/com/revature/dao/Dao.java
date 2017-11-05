package com.revature.dao;

import java.util.List;

import com.revature.beans.Board;
import com.revature.beans.LaneType;
import com.revature.beans.ScrumUser;
import com.revature.beans.Story;
import com.revature.beans.Task;

public interface Dao {

	// CREATE
	public Board createBoard(Board newBoard);

	public void createUserToBoard(Board board, ScrumUser sUser);

	public Task createTask(Task t);

	public void createTaskToStory(Story story, Task task);
	
	public Story createStory(Story s);

	// READ
	public ScrumUser getScrumUserById(ScrumUser sUser);

	public ScrumUser getScrumUserByUsername(ScrumUser sUser);

	public Task getTaskById(Task t);

	public List<Board> getBoardList(ScrumUser sUser);
	
	public Board getBoardById(Board board);

	public List<ScrumUser> getUserList(Board board);

	public List<ScrumUser> getAllUserList();

	public List<LaneType> getLaneTypes();

	public LaneType getLaneById(LaneType lane);

	public List<ScrumUser> getUsersNotOnBoard(Board board);

	// UPDATE

	// DELETE

}
