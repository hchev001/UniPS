package com.unips.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unips.service.MessageService;

@Controller
@RequestMapping
public class MessageController {
	
	@Autowired
	private  MessageService service;
	
	/** 
	 * Sample controller to see how information is retrieved after 
	 * Authentication has succeeded.
	 * TODO: Remove in the Future
	 */
	@RequestMapping("/message")
	@ResponseBody
	public   Map<String, String> userInfo(Authentication authentication) {
		return service.getMsg(authentication);
	}
}	 