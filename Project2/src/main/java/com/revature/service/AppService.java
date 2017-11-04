package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Board;
import com.revature.beans.ScrumUser;
import com.revature.beans.Story;
import com.revature.dao.DaoImpl;

@Service
public class AppService {
	@Autowired
	private DaoImpl dao;

	// returns user if valid login, otherwise returns null
	public ScrumUser getScrumUserByUsername(ScrumUser sUser) {
		ScrumUser loggedInUser = dao.getScrumUserByUsername(sUser);

		// if returned user is not null and passwords don't match, set the returned user
		// to null
		if (loggedInUser != null && !sUser.getScrumUserPassword().equals(loggedInUser.getScrumUserPassword())) {
			loggedInUser = null;
		}
		return loggedInUser;
	}

	public Board addNewBoard(Board newBoard, ScrumUser sUser) {
		newBoard = dao.createBoard(newBoard);
		dao.createUserToBoard(newBoard, sUser);
		return newBoard;
	}
	
	public void addNewStory(Story newStory) {
		dao.createStory(newStory);
	}
	
	public void addUserToBoard(Board board, ScrumUser sUser) {
		dao.createUserToBoard(board, sUser);
	}
	
	public List<Board> getBoardList(ScrumUser sUser) {
		return dao.getBoardList(sUser);
	}
	
	public Board getBoardDetails(Board board) {
		return dao.getBoardById(board);
	}
	
	public List<ScrumUser> getUserList(Board board) {
		return dao.getUserList(board);
	}
	
	public List<ScrumUser> getAllUserList() {
		return dao.getAllUserList();
	}
	
	public List<ScrumUser> getUsersNotOnBoard(Board board) {
		return dao.getUsersNotOnBoard(board);
	}
	
	public ScrumUser getScrumUserById(ScrumUser sUser) {
		return dao.getScrumUserById(sUser);
	}
}
