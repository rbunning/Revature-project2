package com.revature.controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Board;
import com.revature.beans.LaneType;
import com.revature.beans.Story;
import com.revature.service.AppService;

@Controller
public class NewStoryController {
	@Autowired
	AppService service;
	
	@RequestMapping(value = "/newStory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Story> addStory(Story newStory, HttpServletRequest request) {
		
		// Sets the current board to the board in the session cookie.
		HttpSession session = request.getSession();
		Board board = (Board) session.getAttribute("board");
		newStory.setBoard(board);
		
		// Sets the lane type to backlog.
		LaneType lane = service.getLane(new LaneType(1, null));
		newStory.setLaneType(lane);

		// The current date when the story was add. 
		newStory.setLastMoveDate(Date.valueOf(LocalDate.now()));
		
		return new ResponseEntity<Story>(service.addNewStory(newStory), HttpStatus.OK);
	}
}
