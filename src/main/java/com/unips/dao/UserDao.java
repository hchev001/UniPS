package com.unips.dao;

import java.util.List;

import com.unips.constants.BusinessConstants.UserStatus;
import com.unips.entity.User;

public interface UserDao<T> {

	public List<User> getAllUsers();

	public User getUserByUsername(String username);

	public int addUser(User user);

	public User updateUser(User user);
	
	public int deleteUserByusername(String username);
	
	public String verifyEmail(String candidateToken);
	
	public int updateUserStatusByUsername(String username, UserStatus status);

}
