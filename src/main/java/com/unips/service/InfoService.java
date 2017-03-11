package com.unips.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
	@PreAuthorize("hasAnyRole('ADMIN','USER', 'BUSINESS')")
	public String getMsg() {
		return "Hello ";
	}
}