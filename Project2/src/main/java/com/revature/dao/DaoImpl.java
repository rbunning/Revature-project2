package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.ScrumUser;
import com.revature.beans.Task;
import com.revature.util.HibernateConnectionUtil;

public class DaoImpl implements Dao{
	
	//Get an Existing Scrum User from the DB
	public ScrumUser getScrumUserById(ScrumUser sUser) {
		Session session = HibernateConnectionUtil.getSession();
		ScrumUser dbUser = (ScrumUser) session.get(ScrumUser.class, sUser.getScrumUserId());
		session.close();
		return dbUser;
	}
	
	//Create a new Task and Save it to the DB
	@Override
	public void createTask(Task t) {
		Session session = HibernateConnectionUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(t);
		tx.commit();
		session.close();
	}
	
	//Get an Existing Task from the DB
	//Can delete this if not needed
	@Override
	public Task getTaskById(Task t) {
		Session session = HibernateConnectionUtil.getSession();
		Task dbTask = (Task) session.get(Task.class, t.getTaskId());
		session.close();
		return dbTask;
	}
	
}
