package com.unips.dao;

import java.util.List;

import com.unips.entity.User;

public interface UserDao<T> {

	public List<User> getAllUsers();

	public T getUserByUsername(String username);

	public T addUser();

	public T editUserByUsername(String username);
	
	public T deleteUserByusername(String username);

}
