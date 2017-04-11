package com.unips.dao;

import java.util.List;

import com.unips.constants.BusinessConstants.CommentFlag;
import com.unips.constants.BusinessConstants.RatingValue;
import com.unips.constants.BusinessConstants.Status;
import com.unips.entity.Rating;
import com.unips.entity.User;

public interface UserDao {

	public List<User> getAllUsers();

	public User getUser(String username);

	public int addUser(User user);

	public User updateUser(User user);
	
	public int deleteUser(String username);
	
	public String verifyEmail(String candidateToken);
	
	public int updateUserStatus(String username, Status status);

	public List<String> getQuestions(String username);
	
	public boolean exits(String username);
	
	
	// Flag interaction
	public CommentFlag getFlag(Integer commentId);
	
	public CommentFlag updateFlag(Integer commentId, CommentFlag flag);

	
	// Rating interaction
	
	public Rating getRating(int userId, int businessId);
	
	public Rating addRating(int userId, int businessId, RatingValue rate);
	
	public Rating updateRating(int userId, int businessId, RatingValue rate);
}
