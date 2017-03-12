package com.unips.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unips.dao.UserDao;
import com.unips.dao.UserInfoDao;
import com.unips.entity.User;
import com.unips.entity.UserInfo;

@Service
public class UserService<T> {

	private static final int VALID_MAX_COUNT_ONE = 1;

	@Autowired
	@Qualifier("user.mysql")
	UserDao<User> userDao;

	@Autowired
	@Qualifier("userInfo.mysql")
	UserInfoDao userInfoDao;

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	public int addUser(User user) {

		// Make sure the user does not exits
		UserInfo userInfo = userInfoDao.getUserInfo(user.getUsername());

		if (userInfo == null)
			return 0;
		
		
		// Add password and update database
		int update_records = 0;
		
		ShaPasswordEncoder encode = new ShaPasswordEncoder();
		user.setPassword(encode.encodePassword(user.getPassword(), null));
		update_records = userDao.addUser(user);

		// Check updated records and send email
		if (update_records != VALID_MAX_COUNT_ONE)
			return update_records;
		
		//TODO: Send Email.
		
		
		return update_records;

	}

	public int editUserByUsername(String username) {
		return userDao.editUserByUsername(username);
	}

	public int deleteUserByusername(String username) {
		return userDao.deleteUserByusername(username);
	}
}
