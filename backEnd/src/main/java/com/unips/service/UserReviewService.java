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

	public Response<Comment> addReviewForBusiness(Comment comment) {
		
		return Response.success(userReviewDao.addReviewForBusiness(comment));
	}

	public Response<Comment> getReview(Integer reviewId) {
		
		Comment result = userReviewDao.getReview(reviewId);
		
		if (result == null)
			return Response.failure("Review does not exist");
		
		return Response.success(result);
	}

	public Response<Comment> updateReview(Comment review) {
		
		Comment result = userReviewDao.updateReview(review);
		
		if (result == null)
			Response.failure("Review could not be updated");
		
		return Response.success(result);
	}

	public Response<Boolean> deleteReview(Comment review) {
	
		boolean result = userReviewDao.deleteReview(review);
		
		if (!result)
			return Response.failure("Review could not be deleted");
		
		return Response.success(result);
	}

	
	
}
