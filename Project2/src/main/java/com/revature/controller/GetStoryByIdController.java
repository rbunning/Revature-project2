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

import com.revature.beans.Story;
import com.revature.service.AppService;

@RestController
public class GetStoryByIdController {
	
	@Autowired
	AppService service;
	
	@RequestMapping(value = "/getStoryById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Story> getStoryId(Story story, HttpServletRequest request) {
		System.out.println("Story a " + story);
		story = service.getStoryById(story.getStory());
		System.out.println("Story b " + story);
		HttpSession session = request.getSession();
		session.setAttribute("story", story);
		return new ResponseEntity<Story>(story, HttpStatus.OK);
	}
	
	
	
}
