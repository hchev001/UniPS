package com.unips.controller;

import java.util.List;

import org.junit.experimental.theories.ParametersSuppliedBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unips.entity.User;
import com.unips.service.UserService;

@RestController
@RequestMapping("/api/users")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class UserController {

	@Autowired
	UserService<User> service;
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
	@RequestMapping(value="{username}", method = RequestMethod.GET)
	public User getUserByUsername(@PathVariable("username") String username){
		return service.getUserByUsername(username);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public int addUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user){
		return service.updateUser(user);
	}
}
