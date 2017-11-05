package com.revature.controller;

import java.util.List;

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
public class ListBoardsController {
	@Autowired
	AppService service;

	@RequestMapping(value = "/listBoards", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Board>> getBoards(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ScrumUser sUser = (ScrumUser) session.getAttribute("user");
		List<Board> boardList = service.getBoardList(sUser);
		return new ResponseEntity<List<Board>>(boardList, HttpStatus.OK);
	}
}
