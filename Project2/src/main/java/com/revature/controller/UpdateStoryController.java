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

import com.revature.beans.LaneType;
import com.revature.beans.Story;
import com.revature.service.AppService;

@Controller
public class UpdateStoryController {

	@Autowired
	AppService service;

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Story> updateStory(Story newStory, HttpServletRequest request) {

		// Get the id for the form and parses it to get the lane type selected
		String l = request.getParameter("laneTypeId");
		LaneType lane = service.getLane(new LaneType(Integer.parseInt(l), null));
		newStory.setLaneType(lane);
		
		// Get the id for the form and parses it to get the lane type selected
		String i = request.getParameter("storyId");
		newStory.setStory(Integer.parseInt(i));

		return new ResponseEntity<Story>(newStory, HttpStatus.OK);
	}

}
