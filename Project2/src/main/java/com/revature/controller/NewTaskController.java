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
import com.revature.beans.Task;
import com.revature.service.AppService;

@Controller
public class NewTaskController {
	
	@Autowired
	AppService service;
	
	@RequestMapping("/newTask")
	public ModelAndView addTask() {
		return new ModelAndView("/resources/features/addTask.html");
	}
	
	@RequestMapping(value = "/newTask", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Task> addTask(Task newTask, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ScrumUser sUser = (ScrumUser) session.getAttribute("user");
		
		newTask = service.addNewTask(newTask);
		return new ResponseEntity<Task>(newTask, HttpStatus.OK);
	}
	
}
