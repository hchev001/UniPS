package com.unips.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

/* TODO: Sample, remove when finished */
@Service
public class MessageService {
	
	@PreAuthorize("hasAnyRole('ADMIN','USER', 'BUSINESS')")
	public Map<String, String> getMsg(Authentication authentication) {
		
		String msg = "";
		for (GrantedAuthority authority : authentication.getAuthorities()) {
		     String role = authority.getAuthority();
             msg+=authentication.getName()+", You have "+ role;
		}
		
		Map <String, String> map = new HashMap<>();
		map.put("data", msg);
		return map;
	}
}