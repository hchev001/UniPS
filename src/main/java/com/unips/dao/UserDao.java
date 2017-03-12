package com.unips.dao;

import java.util.List;

import com.unips.entity.User;

public interface UserDao<T> {

	public List<User> getAllUsers();

	public User getUserByUsername(String username);

	public int addUser(User user);

	public int editUserByUsername(String username);
	
	public int deleteUserByusername(String username);

}
