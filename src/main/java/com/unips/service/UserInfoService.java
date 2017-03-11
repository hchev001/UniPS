package com.unips.service;

import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements InfoService {
	public String getMsg() {
		return "Hello ";
	}
}