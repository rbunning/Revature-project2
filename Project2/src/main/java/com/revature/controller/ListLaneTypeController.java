package com.revature.controller;

import java.util.List;

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
import com.revature.beans.ScrumUser;
import com.revature.service.AppService;

@Controller
public class ListLaneTypeController {
	@Autowired
	AppService service;
	
	@RequestMapping(value = "/listLanes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LaneType>> getBoards(HttpServletRequest request) {
		List<LaneType> laneList = service.getLaneTypeList();
		return new ResponseEntity<List<LaneType>>(laneList, HttpStatus.OK);
	}
}
