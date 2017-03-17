package com.unips.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unips.entity.User;
import com.unips.service.UserService;

@RestController
public class GeneralController {
	
	@Autowired
	UserService<User> service;
	
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public int addUser(@RequestBody User user) {
		return service.addUser(user);
	}
}
