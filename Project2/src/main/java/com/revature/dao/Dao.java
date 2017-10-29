package com.revature.dao;

import com.revature.beans.ScrumUser;
import com.revature.beans.Task;

public interface Dao {

	public ScrumUser getScrumUserById(ScrumUser sUser);

	public ScrumUser getScrumUserByUsername(ScrumUser sUser);

	public void createTask(Task t);

	public Task getTaskById(Task t);
}
