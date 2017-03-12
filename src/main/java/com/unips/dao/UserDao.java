package com.unips.dao;

import java.util.List;

import com.unips.constants.BusinessConstants.UserStatus;
import com.unips.entity.User;

public interface UserDao<T> {

	public List<User> getAllUsers();

	public User getUserByUsername(String username);

	public int addUser(User user);

	public int updateUserByUsername(String username);
	
	public int deleteUserByusername(String username);
	
	public String getToken(String candidateToken);
	
	public String verifyEmail(String candidateToken);
	
	public int updateUserStatusByUsername(String username, UserStatus status);

}
