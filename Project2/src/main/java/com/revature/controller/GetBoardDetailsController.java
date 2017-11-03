package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

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
		return new ResponseEntity<Board>(service.getBoardDetails(board), HttpStatus.OK);
	}
}
