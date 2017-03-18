package com.unips.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unips.constants.BusinessConstants.Roles;
import com.unips.constants.BusinessConstants.Status;
import com.unips.dao.UserDao;
import com.unips.dao.UserInfoDao;
import com.unips.entity.User;
import com.unips.entity.UserInfo;
import com.unips.mail.SmptMailSender;
import com.unips.response.Response;

@Service
public class UserService<T> {

	private static final int VALID_MAX_COUNT_ONE = 1;

	@Autowired
	@Qualifier("user.mysql")
	UserDao userDao;

	@Autowired
	@Qualifier("userInfo.mysql")
	UserInfoDao userInfoDao;
	
	@Autowired
	SmptMailSender mailSender;

	@PreAuthorize("hasRole('ADMIN')")
	public Response<List<User>> getAllUsers() {
		try {
			return  Response.success(userDao.getAllUsers());
		} catch (Exception e) {
			return Response.failure(e.getMessage());
		}	
	}

	@PreAuthorize("hasAnyRole('ADMIN','USER') and #username == authentication.getName()")
	public Response<User> getUser(String username) {
		
		try {
			return  Response.success(userDao.getUser(username));
		} catch (Exception e) {
			return Response.failure(e.getMessage());
		}
	}

	
	public Response<User> addUser(User user) {
		
		// Make sure the user does not exits
		UserInfo userInfo = userInfoDao.getUserInfo(user.getUsername());

		if (userInfo != null)
			return Response.failure("User already exists");
		
		try {
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
				String url = "http://localhost:8080/api/userVerification?token=" + user.getToken();
				mailSender.sendUserVerificationEmail(user.getEmail(), url);
			} catch (Exception e) {
				// Let it go....
			}
			
			return Response.success(user);
			
		} catch (Exception e) {
			return Response.failure(e.getMessage());
		}
	}
	

	@PreAuthorize("hasAnyRole('ADMIN','USER') and #username == authentication.getName()")
	public Response<User> updateUser(User user) {
		
		try {
		
			// Encode the password
			ShaPasswordEncoder encode = new ShaPasswordEncoder();
			user.setPassword(encode.encodePassword(user.getPassword(), null));
			
			return Response.success(userDao.updateUser(user));
			
		} catch (Exception e) {
			return Response.failure(e.getMessage());
		}
	}
	
	@PreAuthorize("hasAnyRole('ADMIN','USER') and #username == authentication.getName()")
	public Response<Integer> deleteUser(String username) {
		try {
			return Response.success(userDao.deleteUser(username));
		} catch (Exception e) {
			return Response.failure(e.getMessage());
		}
	}
	
	
	public boolean verifyEmail(String candidateToken) {
		
		String username = userDao.verifyEmail(candidateToken);
		
		if (username == null)
			return false;
	
		userDao.updateUserStatus(username, Status.ACTIVE);	
		return true;
	}
}
