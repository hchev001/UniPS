package com.unips.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unips.entity.User;
import com.unips.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	
	@Autowired
	UserService<User> service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
}
