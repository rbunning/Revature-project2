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

import com.revature.beans.ScrumUser;
import com.revature.beans.Story;
import com.revature.beans.Task;
import com.revature.dto.TaskDTO;
import com.revature.service.AppService;

@Controller
public class NewTaskController {
	
	@Autowired
	AppService service;
	
//	@RequestMapping("/newTask")
//	public ModelAndView addTask() {
//		return new ModelAndView("/resources/features/addTask.html");
//	}
	
	@RequestMapping(value = "/newTask", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Task> addTask(TaskDTO newTask, HttpServletRequest request) {
		//public ResponseEntity <Task> addTask(TaskDTO newTask, HttpServletRequest request) {
		System.out.println("Testing new Task");
		System.out.println("New task is: " + newTask);
		HttpSession session = request.getSession();
		ScrumUser sUser = (ScrumUser) session.getAttribute("user");
		Story story = service.getStoryById(newTask.getStoryId());
		Task t = new Task(story, newTask.getTaskDescription());
		System.out.println("Task t = " + t);
		t = service.addNewTask(t);
		return new ResponseEntity<Task>(t, HttpStatus.OK);
	}
	
}
