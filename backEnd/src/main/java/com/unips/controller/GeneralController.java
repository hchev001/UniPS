package com.unips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unips.entity.User;
import com.unips.response.Response;
import com.unips.service.UserService;

@RestController
public class GeneralController {
	
	@Autowired
	UserService<User> service;
	
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	@ResponseBody
	public Response<User> addUser(@RequestBody User user) {
		return service.addUser(user);
	}
}
