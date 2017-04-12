package com.unips.dao;

import java.util.List;

import com.unips.entity.Comment;

public interface UserReviewDao {
	
	public List<Comment> getAllReviews(String userName);

	public List<Comment> getAllReviewsForBusiness(String userName, String businessName);

	public Comment addReviewForBusiness(String userName, String businessName);

	public Comment getReview(String userName, Integer reviewId);

	public Comment updateReview(String userName, Integer reviewId);

	public Boolean deleteReview(String userName, Integer reviewId);

}
