package com.unips.service.admin;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unips.constants.BusinessConstants.Roles;
import com.unips.constants.BusinessConstants.Status;
import com.unips.dao.AdminDao;
import com.unips.dao.UserDao;
import com.unips.dao.UserInfoDao;
import com.unips.entity.User;
import com.unips.mail.SmptMailSender;
import com.unips.response.Response;
import com.unips.service.UserService;

@Service
public class AdminService<T> {

	private static final int VALID_MAX_COUNT_ONE = 1;
	private static final String ADMIN_VERIFICATION_API = "http://localhost:8080/api/adminVerification?token=";
	private static final String ADMIN_APPROVAL_API = "http://localhost:8080/api/adminApproval?token=";
	private static final String HOME_URL = "http://localhost:8080/";
			
	@Autowired
	@Qualifier("admin.mysql")
	AdminDao adminDao;

	@Autowired
	@Qualifier("userInfo.mysql")
	UserInfoDao userInfoDao;
	
	@Autowired
	SmptMailSender mailSender;
	
	
	@Autowired
	UserDao userDao;
	
	
	@PreAuthorize("hasRole('ADMIN')")
	public Response<List<User>> getAllAdmins() {
		return  Response.success(adminDao.getAllAdmins());
	}

	@PreAuthorize("#username == authentication.getName()")
	public Response<User> getAdmin(String username) {
		return  Response.success(adminDao.getAdmin(username));
	}

	
	@PreAuthorize("permitAll()")
	public Response<User> addAdmin(User user) {
		
		// Make sure the user does not exits
		if (adminDao.exits(user.getUsername()))
			return Response.failure("Username already exists");
		
		// Add created fields
		int updated_records = 0;

		ShaPasswordEncoder encode = new ShaPasswordEncoder();
		user.setPassword(encode.encodePassword(user.getPassword(), null));
		user.setToken(UUID.randomUUID().toString());
		user.setStatus(Status.DISABLED);
		user.setRole(Roles.ROLE_ADMIN);

		updated_records = adminDao.addAdmin(user);

		// Check updated records and send email
		if (updated_records != VALID_MAX_COUNT_ONE)
			return Response.failure("More than one record updated in the database");

		// Send Email
		try {
			String url = ADMIN_VERIFICATION_API + user.getToken();
			mailSender.sendUserVerificationEmailAdmins(user.getEmail(), url);
		} catch (Exception e) {
			// Let it go....
		}

		return Response.success(user);
	}
	

	@PreAuthorize("hasAnyRole('ADMIN') or #username == authentication.getName()")
	public Response<User> updateAdmin(User user) {

		// Encode the password
		ShaPasswordEncoder encode = new ShaPasswordEncoder();
		user.setPassword(encode.encodePassword(user.getPassword(), null));

		return Response.success(adminDao.updateAdmin(user));
	}
	
	@PreAuthorize("#username == authentication.getName()")
	public Response<Integer> deleteUser(String username) {
		return Response.success(adminDao.deleteAdmin(username));
	}
	
	@PreAuthorize("permitAll()")
	public boolean verifyEmail(String candidateToken) {
		
		String username = adminDao.verifyEmail(candidateToken);

		if (username == null)
			return false;
		
		try {
			// Send Email for verification and letting them know we will process it in time
			User user = adminDao.getAdmin(username);
			
			String url = ADMIN_APPROVAL_API + user.getUsername();
			mailSender.sendAdminVerificationEmailToAdmins(user, url);

		} catch (Exception e) {
			// Let it go....
		}

		return true;
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	public boolean approveAdmin(String candidateToken) {
		
		boolean result = adminDao.approveAdmin(candidateToken);
		
		User user = userDao.getUser(candidateToken);
		
		try {
			mailSender.sendThankYouEmail(user.getEmail(), HOME_URL);
		} catch (Exception e) {
			// Let it go
		}
		
		return result;
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	public boolean approveBusiness(String candidateToken) {
		return adminDao.approveBusiness(candidateToken);
	}
}
