package com.revature.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Board;
import com.revature.beans.ScrumUser;
import com.revature.beans.Story;
import com.revature.beans.Task;

@Repository
@Transactional
public class DaoImpl implements Dao {
	@Autowired
	SessionFactory sessionFactory;

	// Get an existing Scrum User from the DB.
	@Override
	public ScrumUser getScrumUserById(ScrumUser sUser) {
		Session session = sessionFactory.getCurrentSession();
		ScrumUser dbUser = (ScrumUser) session.get(ScrumUser.class, sUser.getScrumUserId());
		return dbUser;
	}

	// Get an existing Scrum User from the DB (used for login).
	@Override
	public ScrumUser getScrumUserByUsername(ScrumUser sUser) {
		Session session = sessionFactory.getCurrentSession();
		ScrumUser dbUser = (ScrumUser) session.createCriteria(ScrumUser.class)
				.add(Restrictions.eq("scrumUserUsername", sUser.getScrumUserUsername())).uniqueResult();
		// force loading of boards
		dbUser.getBoards().size();
		return dbUser;
	}

	// Creates a new Task and save it to the DB.
	@Override
	public Task createTask(Task t) {
		Session session = sessionFactory.getCurrentSession();
		session.save(t);
		return t;
	}

	@Override
	public void createTaskToStory(Story story, Task task) {
		Session session = sessionFactory.getCurrentSession();
		//setting story to update the story id
		task.setStory(story);
		session.update(task);
	}

	// Get an existing Task from the DB.
	// Can delete this if not needed
	@Override
	public Task getTaskById(Task t) {
		Session session = sessionFactory.getCurrentSession();
		Task dbTask = (Task) session.get(Task.class, t.getTaskId());
		return dbTask;
	}

	// Creates a new Board and save it to the DB.
	@Override
	public Board createBoard(Board newBoard) {
		Session session = sessionFactory.getCurrentSession();
		session.save(newBoard);
		return newBoard;
	}

	// Creates a new join between the Board and Scrum User and save it to the DB.
	@Override
	public void createUserToBoard(Board board, ScrumUser sUser) {
		Session session = sessionFactory.getCurrentSession();
		// force board list to load
		int boardListSize = sUser.getBoards().size();
		sUser.getBoards().add(board);
		session.update(sUser);
	}

	@Override
	public List<Board> getBoardList(ScrumUser sUser) {
		Session session = sessionFactory.getCurrentSession();
		// force board list to load
		int boardListSize = sUser.getBoards().size();
		List<Board> boardList = new ArrayList<Board>();
		Set<Board> boardSet = sUser.getBoards();
		boardList.addAll(boardSet);
		return boardList;
	}

	// Creates a new Story and save it to the DB.
	@Override
	public void createStory(Story s) {
		Session session = sessionFactory.getCurrentSession();
		session.save(s);
	}

	@Override
	public Board getBoardById(Board board) {
		Session session = sessionFactory.getCurrentSession();
		board = (Board) session.get(Board.class, board.getBoardId());
		board.getStory().size();
		for(Story s : board.getStory()) {
			s.getTask().size();
		}
		return board;
	}

	@Override
	public List<ScrumUser> getUserList(Board board) {
		Session session = sessionFactory.getCurrentSession();
		board = (Board) session.get(Board.class, board.getBoardId());
		board.getScrumUsers().size();
		List<ScrumUser> userList = new ArrayList<ScrumUser>();
		Set<ScrumUser> userSet = board.getScrumUsers();
		for (ScrumUser su : userSet) {
			su.getBoards().size();
		}
		userList.addAll(userSet);
		return userList;
	}

	@Override
	public List<ScrumUser> getAllUserList() {
		Session session = sessionFactory.getCurrentSession();
		List<ScrumUser> userList = session.createCriteria(ScrumUser.class).list();
		for (ScrumUser su : userList) {
			su.getBoards().size();
		}

		return userList;
	}
}
