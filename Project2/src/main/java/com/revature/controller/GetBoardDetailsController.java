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
import com.revature.service.AppService;

@RestController
public class GetBoardDetailsController {
	@Autowired
	AppService service;

	@RequestMapping(value = "/boardDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Board> getBoardDetails(Board board, HttpServletRequest request) {
		board = service.getBoardDetails(board);
		// Store the currently selected board into the session
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/boardDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Board> getCurrentBoardDetails(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Board board = (Board) session.getAttribute("board");
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
}
