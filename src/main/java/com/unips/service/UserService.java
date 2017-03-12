package com.unips.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unips.dao.UserDao;
import com.unips.entity.User;

@Service
public class UserService <T> {

	
	@Autowired
	@Qualifier("user.mysql")
	UserDao<User> userDao; 
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	
	public T getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	public T addUser() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public T editUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public T deleteUserByusername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
