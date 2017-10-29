package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.ScrumUser;
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
}
