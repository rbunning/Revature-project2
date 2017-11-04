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

import com.revature.beans.Board;
import com.revature.beans.ScrumUser;
import com.revature.service.AppService;

@RestController
public class NewBoardController {
	@Autowired
	AppService service;

	@RequestMapping(value = "/newBoard", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Board> addBoard(Board newBoard, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ScrumUser sUser = (ScrumUser) session.getAttribute("user");
		newBoard = service.addNewBoard(newBoard, sUser);
		session.setAttribute("board", newBoard);
		return new ResponseEntity<Board>(newBoard, HttpStatus.OK);
	}
}
