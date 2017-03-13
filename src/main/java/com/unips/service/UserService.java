package com.unips.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unips.constants.BusinessConstants.UserRoles;
import com.unips.constants.BusinessConstants.UserStatus;
import com.unips.dao.UserDao;
import com.unips.dao.UserInfoDao;
import com.unips.entity.User;
import com.unips.entity.UserInfo;
import com.unips.mail.SmptMailSender;

@Service
public class UserService<T> {

	private static final int VALID_MAX_COUNT_ONE = 1;

	@Autowired
	@Qualifier("user.mysql")
	UserDao<User> userDao;

	@Autowired
	@Qualifier("userInfo.mysql")
	UserInfoDao userInfoDao;
	
	@Autowired
	SmptMailSender mailSender;

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	public int addUser(User user) {

		// Make sure the user does not exits
		UserInfo userInfo = userInfoDao.getUserInfo(user.getUsername());

		if (userInfo != null)
			return 0;
		
		// Add created fields
		int updated_records = 0;
		
		ShaPasswordEncoder encode = new ShaPasswordEncoder();
		user.setPassword(encode.encodePassword(user.getPassword(), null));
		user.setToken(UUID.randomUUID().toString());
		user.setStatus(UserStatus.DISABLED);
		user.setRole(UserRoles.ROLE_USER);
		
		updated_records = userDao.addUser(user);

		// Check updated records and send email
		if (updated_records != VALID_MAX_COUNT_ONE)
			return updated_records;
		
		// Send Email
		try {
			String url = "http://localhost:8080/userVerification?token=" + user.getToken();
			mailSender.sendUserVerificationEmail(user.getEmail(), url);
		} catch (Exception e) {
			// Let it go....
		}
		
		return updated_records;
	}

	public boolean verifyEmail(String candidateToken) {
		
		String username = userDao.verifyEmail(candidateToken);
		
		if (username == null)
			return false;
	
		userDao.updateUserStatusByUsername(username, UserStatus.ACTIVE);	
		return true;
	}
	

	public User updateUser(User user) {
		
		// Encode the password
		ShaPasswordEncoder encode = new ShaPasswordEncoder();
		user.setPassword(encode.encodePassword(user.getPassword(), null));
		
		return userDao.updateUser(user);
	}

	public int deleteUserByusername(String username) {
		return userDao.deleteUserByusername(username);
	}
}
