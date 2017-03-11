package com.unips.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unips.constants.Constants.EnumRoles;
import com.unips.dao.UserDao;
import com.unips.entity.UserInfo;

@Service
public class UserInfoService {
	
	@Autowired
	@Qualifier("mysql")
	UserDao userDao;
	
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public String getMsg() {
		return "Hello ";
	}
	
	
	public int addUser(UserInfo user) {
		
		ShaPasswordEncoder encoder = new ShaPasswordEncoder();
		
		String hash = encoder.encodePassword(user.getPassword(), 1);
		user.setPassword(hash);
		user.setEnabled(1);
		return userDao.addUserInfo(user);
	}
}