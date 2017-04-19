package com.unips.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.unips.dao.BusinessDao;
import com.unips.dao.UserDao;
import com.unips.dao.UserReviewDao;
import com.unips.entity.Business;
import com.unips.entity.Comment;
import com.unips.entity.User;
import com.unips.response.Response;

@Service
public class UserReviewService<T> {
	
	@Autowired
	@Qualifier("userReviewDao.mysql")
	UserReviewDao userReviewDao;
	
	@Autowired
	@Qualifier("user.mysql")
	UserDao userDao;
	
	@Autowired
	@Qualifier("business.mysql")
	BusinessDao businessDao;
	
	@PreAuthorize("hasAnyRole('ADMIN') or #userName == authentication.getName()")
	public Response<List<Comment>> getAllReviews(String userName) {

		User user = userDao.getUser(userName);
		if (user == null)
			return Response.failureUserNotFound();
		
		return Response.success(userReviewDao.getAllReviews(user.getId()));
	}

	public Response<List<Comment>> getAllReviewsForBusiness(String userName, String businessName) {
		
		User user = userDao.getUser(userName);
		if (user == null) 
			return Response.failureUserNotFound();
		
		Business business = businessDao.getBusiness(businessName);
		if (business == null)
			return Response.failureBusinessNotFound();
		
		return Response.success(userReviewDao.getAllReviewsForBusiness(user.getId(), business.getId()));
	}

	public Response<Comment> addReviewForBusiness(String userName, String businessName, Comment comment) {
		
		User user = userDao.getUser(userName);
		if (user == null) 
			return Response.failureUserNotFound();
		
		Business business = businessDao.getBusiness(businessName);
		if (business == null)
			return Response.failureBusinessNotFound();
		
		return Response.success(userReviewDao.addReviewForBusiness(user.getId(), business.getId(), comment));
	}

	public Response<Comment> getReview(String userName, Integer reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response<Comment> updateReview(String userName, Integer reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response<Boolean> deleteReview(String userName, Integer reviewId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
