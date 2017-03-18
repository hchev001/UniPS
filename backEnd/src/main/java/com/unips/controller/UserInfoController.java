package com.unips.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;

@Controller
@Api(tags="Registration and Login")
public class UserInfoController {

	@RequestMapping(value="/api/userInfo", method=RequestMethod.GET)
	@ResponseBody
	public Principal user(Principal user) {
		return user;
	}
}
