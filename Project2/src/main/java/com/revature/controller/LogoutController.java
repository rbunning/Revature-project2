package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogoutController {

	@RequestMapping(value = "/logout")
	public void logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		session.setAttribute("board", null);
		session.invalidate();
	}
}
