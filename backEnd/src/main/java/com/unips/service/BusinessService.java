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
import com.unips.dao.BusinessDao;
import com.unips.dao.BusinessReviewDao;
import com.unips.dao.UserInfoDao;
import com.unips.entity.Business;
import com.unips.mail.SmptMailSender;
import com.unips.response.Response;

@Service
public class BusinessService<T> {

	private static final int VALID_MAX_COUNT_ONE = 1;
	private static final String BUSINESS_VERICATION_API = "http://localhost:8080/api/businessVerification?token=";
	private static final String BUSINESS_APPROVAL_API = "http://localhost:8080/api/businessApproval?token=";

	@Autowired
	@Qualifier("business.mysql")
	BusinessDao businessDao;

	@Autowired
	@Qualifier("businessReview.mysql")
	BusinessReviewDao businessReviewDao;

	@Autowired
	@Qualifier("userInfo.mysql")
	UserInfoDao userInfoDao;

	@Autowired
	SmptMailSender mailSender;

	public Response<List<Business>> getAllBusiness() {
		List<Business> business = businessDao.getAllBusiness();
		return Response.success(business);
	}

	public Response<Business> getBusiness(String username) {
		return Response.success(businessDao.getBusiness(username));
	}

	@PreAuthorize("permitAll()")
	public Response<Business> addBusiness(Business business) {

		// Make sure the user does not exits
		if (businessDao.exits(business.getUsername()))
			return Response.failure("Username already exists");

		// Add created fields
		int updated_records = 0;

		ShaPasswordEncoder encode = new ShaPasswordEncoder();
		business.setPassword(encode.encodePassword(business.getPassword(), null));
		business.setToken(UUID.randomUUID().toString());
		business.setStatus(Status.DISABLED);
		business.setRole(Roles.ROLE_BUSINESS);

		updated_records = businessDao.addBusiness(business);

		// Check updated records and send email
		if (updated_records != VALID_MAX_COUNT_ONE)
			return Response.failure("More than one record updated in the database");

		// Send Email for verification and letting them know we will process
		// it in time.
		try {
			String url = BUSINESS_VERICATION_API + business.getToken();
			mailSender.sendUserVerificationEmailBusiness(business.getEmail(), url);

		} catch (Exception e) {
			// Let it go....
		}

		return Response.success(business);
	}

	@PreAuthorize("hasAnyRole('ADMIN') or #username == authentication.getName()")
	public Response<Business> updateBusiness(Business business) {

		// Encode the password
		ShaPasswordEncoder encode = new ShaPasswordEncoder();
		business.setPassword(encode.encodePassword(business.getPassword(), null));

		return Response.success(businessDao.updateBusiness(business));
	}

	@PreAuthorize("hasAnyRole('ADMIN') or #username == authentication.getName()")
	public Response<Integer> deleteBusiness(String username) {
		return Response.success(businessDao.deleteBusiness(username));
	}

	public boolean verifyEmail(String candidateToken) {

		String username = businessDao.verifyEmail(candidateToken);

		if (username == null)
			return false;
		
		try {
			// Send Email for verification and letting them know we will process it in time
			Business business = businessDao.getBusiness(username);
			
			String url = BUSINESS_APPROVAL_API + business.getUsername();
			mailSender.sendUserVerificationEmailToAdmins(business, url);

		} catch (Exception e) {
			// Let it go....
		}

		return true;
	}

}
