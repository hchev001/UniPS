package com.unips.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unips.dao.UserReviewDao;
import com.unips.entity.Comment;
import com.unips.response.Response;

@Service
public class UserReviewService<T> {
	
	@Qualifier("userReviewDao.mysql")
	@Autowired
	UserReviewDao userReview;
	
	
	public Response<List<Comment>> getAllReviews(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response<List<Comment>> getAllReviewsForBusiness(String userName, String businessName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response<Comment> addReviewForBusiness(String userName, String businessName) {
		// TODO Auto-generated method stub
		return null;
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
