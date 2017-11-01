package com.revature.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.revature.beans.Story;
import com.revature.service.AppService;

@Controller
public class NewStoryController {
	
	@Autowired
	AppService service;
	
	// Maps all unused requests.
	@RequestMapping("/newStory")
	public ModelAndView addStory() {
		return new ModelAndView("/resources/features/addStory.html");
	}
	
	// Maps post requests.
	@RequestMapping(value="/newStory", method=RequestMethod.POST)
	public void addStoryPost(Story story, HttpServletRequest request, HttpServletResponse response) {
		
		
		
		
		try {
			response.sendRedirect("newStory");
		} catch (IOException e) {}
	}
}
