package com.unips.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unips.constants.BusinessConstants.CommentFlag;
import com.unips.constants.BusinessConstants.RatingValue;
import com.unips.constants.BusinessConstants.Roles;
import com.unips.constants.BusinessConstants.Status;
import com.unips.dao.BusinessDao;
import com.unips.dao.BusinessReviewDao;
import com.unips.dao.UserDao;
import com.unips.dao.UserInfoDao;
import com.unips.entity.Business;
import com.unips.entity.Comment;
import com.unips.entity.Rating;
import com.unips.entity.User;
import com.unips.mail.SmptMailSender;
import com.unips.response.Response;

@Service
public class UserService<T> {

	private static final int VALID_MAX_COUNT_ONE = 1;
	private static final String USER_VERIFICATION_API = "http://localhost:8080/api/userVerification?token=";

	@Autowired
	@Qualifier("user.mysql")
	UserDao userDao;

	@Autowired
	@Qualifier("userInfo.mysql")
	UserInfoDao userInfoDao;
	
	@Autowired
	@Qualifier("business.mysql")
	BusinessDao businessDao;
	
	@Autowired
	@Qualifier("businessReview.mysql")
	BusinessReviewDao businessReview;
	
	@Autowired
	SmptMailSender mailSender;

	@PreAuthorize("hasRole('ADMIN')")
	public Response<List<User>> getAllUsers() {
		return  Response.success(userDao.getAllUsers());
	}

	@PreAuthorize("#username == authentication.getName()")
	public Response<User> getUser(String username) {
		return  Response.success(userDao.getUser(username));
	}

	
	@PreAuthorize("permitAll()")
	public Response<User> addUser(User user) {
		
		// Make sure the user does not exits
		if (userDao.exits(user.getUsername()))
			return Response.failure("Username already exists");
		
		// Add created fields
		int updated_records = 0;

		ShaPasswordEncoder encode = new ShaPasswordEncoder();
		user.setPassword(encode.encodePassword(user.getPassword(), null));
		user.setToken(UUID.randomUUID().toString());
		user.setStatus(Status.DISABLED);
		user.setRole(Roles.ROLE_USER);

		updated_records = userDao.addUser(user);

		// Check updated records and send email
		if (updated_records != VALID_MAX_COUNT_ONE)
			return Response.failure("More than one record updated in the database");

		// Send Email
		try {
			String url = USER_VERIFICATION_API + user.getToken();
			mailSender.sendUserVerificationEmail(user.getEmail(), url);
		} catch (Exception e) {
			// Let it go....
		}

		return Response.success(user);
	}
	

	@PreAuthorize("hasAnyRole('ADMIN') or #username == authentication.getName()")
	public Response<User> updateUser(User user) {

		// Encode the password
		ShaPasswordEncoder encode = new ShaPasswordEncoder();
		user.setPassword(encode.encodePassword(user.getPassword(), null));

		return Response.success(userDao.updateUser(user));
	}
	
	@PreAuthorize("#username == authentication.getName()")
	public Response<Integer> deleteUser(String username) {
		return Response.success(userDao.deleteUser(username));
	}
	
	@PreAuthorize("permitAll()")
	public boolean verifyEmail(String candidateToken) {
		
		String username = userDao.verifyEmail(candidateToken);
		
		if (username == null)
			return false;
	
		userDao.updateUserStatus(username, Status.ACTIVE);	
		
		try {
			final String link = "http://localhost:8080/";
			mailSender.sendThankYouEmail(username, link);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@PreAuthorize("hasAnyRole('ADMIN') or #username == authentication.getName()")
	public Response<CommentFlag> updateFlag(Integer commentId) {
		
		Comment comment = businessReview.getComment(commentId);
		
		// This means that the comment went from ok to flagged.
		if (comment.getFlag() == CommentFlag.OK) {
			try {
				mailSender.sendCommentFlagNotificationToAdmins(comment);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Response.success(userDao.updateFlag(commentId, comment.getFlag().toggle()));
	}
	
	
	// User ratings Interaction
	@PreAuthorize("hasAnyRole('ADMIN') or #username == authentication.getName()")
	public Response<Rating> getRating(String userName, String businessName) {
		
		User user = userDao.getUser(userName);
		if (user == null)
			return Response.failure("User could not be found");
		
		Business business = businessDao.getBusiness(businessName);
		if (business == null)
			return Response.failure("Business could not be found");
		
		
		return Response.success(userDao.getRating(user.getId(), business.getId()));
	}
	
	@PreAuthorize("hasAnyRole('ADMIN') or #username == authentication.getName()")
	public Response<Rating> addRating(String userName, String businessName, RatingValue rate) {
		
		User user = userDao.getUser(userName);
		if (user == null)
			return Response.failure("User could not be found");
		
		Business business = businessDao.getBusiness(businessName);
		if (business == null)
			return Response.failure("Business could not be found");
		
		return Response.success(userDao.addRating(user.getId(), business.getId(), rate));
	}
	
	@PreAuthorize("hasAnyRole('ADMIN') or #username == authentication.getName()")
	public Response<Rating> updateRating(String userName, String businessName, RatingValue rate) {
		
		User user = userDao.getUser(userName);
		if (user == null)
			return Response.failure("User could not be found");
		
		Business business = businessDao.getBusiness(businessName);
		if (business == null)
			return Response.failure("Business could not be found");
		
		return Response.success(userDao.updateRating(user.getId(), business.getId(), rate));
	}
	
}
