package com.unips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unips.entity.User;
import com.unips.service.UserService;

@Controller
public class UserVerificationController {
	
	@Autowired
	UserService<User> service;
	
	@RequestMapping("/userVerification")
	@ResponseBody
	public boolean verifyEmail(@RequestParam("token") String candidateToken) {
		return service.verifyEmail(candidateToken);
	}

}
