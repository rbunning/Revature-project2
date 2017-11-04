package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Board;
import com.revature.beans.ScrumUser;
import com.revature.service.AppService;

@RestController
public class AddUserToBoardController {
	@Autowired
	AppService service;

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void addUserToBoard(ScrumUser user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Board board = (Board) session.getAttribute("board");
		user = service.getScrumUserById(user);
		service.addUserToBoard(board, user);
	}
}
