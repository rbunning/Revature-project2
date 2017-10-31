package com.revature.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Board;
import com.revature.beans.BoardUserJoin;
import com.revature.beans.ScrumUser;
import com.revature.beans.Story;
import com.revature.beans.Task;

@Repository
@Transactional
public class DaoImpl implements Dao {
	@Autowired
	SessionFactory sessionFactory;

	// Get an Existing Scrum User from the DB
	@Override
	public ScrumUser getScrumUserById(ScrumUser sUser) {
		Session session = sessionFactory.getCurrentSession();
		ScrumUser dbUser = (ScrumUser) session.get(ScrumUser.class, sUser.getScrumUserId());
		return dbUser;
	}

	// Get an Existing Scrum User from the DB (used for login)
	@Override
	public ScrumUser getScrumUserByUsername(ScrumUser sUser) {
		Session session = sessionFactory.getCurrentSession();
		ScrumUser dbUser = (ScrumUser) session.createCriteria(ScrumUser.class)
				.add(Restrictions.eq("scrumUserUsername", sUser.getScrumUserUsername())).uniqueResult();
		return dbUser;
	}

	// Create a new Task and Save it to the DB
	@Override
	public void createTask(Task t) {
		sessionFactory.getCurrentSession().save(t);
	}

	// Get an Existing Task from the DB
	// Can delete this if not needed
	@Override
	public Task getTaskById(Task t) {
		Session session = sessionFactory.getCurrentSession();
		Task dbTask = (Task) session.get(Task.class, t.getTaskId());
		return dbTask;
	}

	// Adds a new board.
	@Override
	public Board addBoard(Board newBoard) {
		Session session = sessionFactory.getCurrentSession();
		session.save(newBoard);
		return newBoard;
	}

	// Adds a new connection between a scrum user and a board.
	@Override
	public void addUserToBoard(Board board, ScrumUser sUser) {
		Session session = sessionFactory.getCurrentSession();
		BoardUserJoin buj = new BoardUserJoin(board,sUser);
		session.save(buj);
	}

	// Adds a new Story.
	@Override
	public void addStory(Story story) {
		Session session = sessionFactory.getCurrentSession();
		session.save(story);
	}
}
