package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.ScrumUser;
import com.revature.service.AppService;

@RestController
public class LoginController {
	@Autowired
	AppService service;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScrumUser> login(ScrumUser user, HttpServletRequest request) {
		String username = user.getScrumUserUsername();
		String password = user.getScrumUserPassword();
		if (username != null && password != null && username != "" && password != "") {
			user = service.getScrumUserByUsername(user);
			if (user != null) {
				// Store the valid user into the session
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				return new ResponseEntity<ScrumUser>(user, HttpStatus.OK);
			}
		}
		user = null;
		return new ResponseEntity<ScrumUser>(user, HttpStatus.BAD_REQUEST);
	}
}
