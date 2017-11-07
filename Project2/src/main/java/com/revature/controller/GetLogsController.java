package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Logs;
import com.revature.service.AppService;

@Controller
public class GetLogsController {
	@Autowired
	AppService service;

	@RequestMapping(value = "/allLogs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Logs>> getAllLogs(HttpServletRequest request) {
		return new ResponseEntity<List<Logs>>(service.getLogList(), HttpStatus.OK);
	}

}
