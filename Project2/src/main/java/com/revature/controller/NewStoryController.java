package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.revature.beans.Board;
import com.revature.beans.ScrumUser;
import com.revature.service.AppService;

@Controller
public class NewStoryController {
	
	@Autowired
	AppService service;
	
	@RequestMapping(value = "/newStory")
	public ModelAndView addBoard() {
		return new ModelAndView("/resources/features/addStory.html");
	}
	
	@RequestMapping(value = "/newBoard", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Board> addBoard(Board newBoard, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ScrumUser sUser = (ScrumUser) session.getAttribute("user");
		newBoard = service.addNewBoard(newBoard, sUser);
		return new ResponseEntity<Board>(newBoard, HttpStatus.OK);
	}
}
