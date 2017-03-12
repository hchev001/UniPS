package com.unips.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserInfoController {

	@RequestMapping("/userInfo")
	@ResponseBody
	public Principal user(Principal user) {
		return user;
	}
}
