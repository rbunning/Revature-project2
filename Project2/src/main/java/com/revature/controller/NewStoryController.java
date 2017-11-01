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

import com.revature.beans.ScrumUser;
import com.revature.beans.Story;
import com.revature.service.AppService;

@Controller
public class NewStoryController {
	
	@Autowired
	AppService service;
	
	@RequestMapping(value = "/newStory")
	public ModelAndView addBoard() {
		return new ModelAndView("/resources/features/addStory.html");
	}
	
	@RequestMapping(value = "/newStory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addBoard(Story newStory, HttpServletRequest request) {
		service.addNewStory(newStory);
	}
}
