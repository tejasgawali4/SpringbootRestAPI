package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	final static Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping("/hello")
	public String sayHello()
	{
		return "Hello";
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Users>> getAllEmployees() {
		List<Users> users = userService.getAll();
		if (users.isEmpty()) {
			logger.debug("Employees does not exists");
			return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + users.size() + " Users");
		logger.debug(Arrays.toString(users.toArray()));
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}
	
	
}
