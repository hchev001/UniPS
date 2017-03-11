package com.unips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unips.entity.UserInfo;
import com.unips.service.UserInfoService;

@Controller
@RequestMapping
public class UserInfoController {
	
	@Autowired
	private  UserInfoService service;
	
	@RequestMapping("/info")
	public @ResponseBody String userInfo(Authentication authentication) {
		String msg = "";
		for (GrantedAuthority authority : authentication.getAuthorities()) {
		     String role = authority.getAuthority();
                     msg+=service.getMsg()+ authentication.getName()+", You have "+ role;
		}
		return msg;
	}
	
	
	@RequestMapping(value="/signup", method=RequestMethod.POST) 
	@ResponseBody
	public int addUser(@RequestBody UserInfo user){
		int result = service.addUser(user);
		return result;
	}
}	 