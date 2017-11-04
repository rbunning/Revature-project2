package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
public class GetAllUsersController {
	@Autowired
	AppService service;

	@RequestMapping(value = "/allUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScrumUser>> getAllUsers(HttpServletRequest request) {
		return new ResponseEntity<List<ScrumUser>>(service.getAllUserList(), HttpStatus.OK);
	}
}
