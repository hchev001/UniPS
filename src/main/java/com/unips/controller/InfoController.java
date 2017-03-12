package com.unips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unips.service.InfoService;

@Controller
@RequestMapping
public class InfoController {
	
	@Autowired
	private  InfoService service;
	
	/** 
	 * Sample controller to see how information is retrieved after 
	 * Authentication has succeeded.
	 * TODO: Remove in the Future
	 */
	@RequestMapping("/info")
	public @ResponseBody String userInfo(Authentication authentication) {
		String msg = "";
		for (GrantedAuthority authority : authentication.getAuthorities()) {
		     String role = authority.getAuthority();
                     msg+=service.getMsg()+ authentication.getName()+", You have "+ role;
		}
		return msg;
	}
}	 