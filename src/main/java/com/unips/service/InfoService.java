package com.unips.service;

import org.springframework.security.access.prepost.PreAuthorize;

public interface InfoService {
	@PreAuthorize("hasAnyRole('ADMIN','USER', 'BUSINESS')")
	public String getMsg();
}