package com.unips.dao;

import java.util.List;

import com.unips.entity.Comment;

public interface UserReviewDao {
	
	public List<Comment> getAllReviews(int userId);

	public List<Comment> getAllReviewsForBusiness(int userId, int businessId);

	public Comment addReviewForBusiness(int userId, int businessId);

	public Comment getReview(int userId, int businessId);

	public Comment updateReview(int userId, int businessId);

	public Boolean deleteReview(int userId, int businessId);

}
