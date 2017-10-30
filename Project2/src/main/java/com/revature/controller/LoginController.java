package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.ScrumUser;
import com.revature.service.AppService;

@RestController
public class LoginController {
	@Autowired
	AppService service;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(ScrumUser user, HttpServletRequest request) {
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		if (username != null && password != null && username != "" && password != "") {
			ScrumUser su = new ScrumUser(username, password);
			su = service.getScrumUserByUsername(su);
			System.out.println(su);
			if (su != null) {
				// Store the valid user into the session
				HttpSession session = request.getSession();
				session.setAttribute("user", su);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", su.getScrumUserId());
				jsonObject.put("role", su.getRoleId().getRoleName());
				jsonObject.put("firstname", su.getScrumUserFirstname());
				jsonObject.put("lastname", su.getScrumUserLastname());
				jsonObject.put("username", su.getScrumUserUsername());
				return new ResponseEntity<String>(jsonObject.toJSONString(), HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>("Invalid Login", HttpStatus.BAD_REQUEST);
	}
}
