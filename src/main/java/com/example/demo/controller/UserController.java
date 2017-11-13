package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Users> addEmployee(@RequestBody Users users) {
		userService.save(users);
		logger.debug("Added:: " + users);
		return new ResponseEntity<Users>(users, HttpStatus.CREATED);
	}


	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(@RequestBody Users users) {
		Users existingEmp = userService.getById(users.getId());
		if (existingEmp == null) {
			logger.debug("Users with id " + users.getId() + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.save(users);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Users> getUser(@PathVariable("id") Long id) {
		Users users = userService.getById(id);
		if (users == null) {
			logger.debug("User with id " + id + " does not exists");
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found User:: " + users);
		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> users = userService.getAll();
		if (users.isEmpty()) {
			logger.debug("User does not exists");
			return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + users.size() + " Users");
		logger.debug(Arrays.toString(users.toArray()));
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		Users users = userService.getById(id);
		if (users == null) {
			logger.debug("User with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.delete(id);
			logger.debug("User with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
	
	
}
