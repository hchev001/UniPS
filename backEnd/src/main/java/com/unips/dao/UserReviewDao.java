package com.unips.dao;

import java.util.List;

import com.unips.entity.Comment;

public interface UserReviewDao {
	
	public List<Comment> getAllReviews(int userId);

	public List<Comment> getAllReviewsForBusiness(int userId, int businessId);

	public Comment addReviewForBusiness(Comment review);

	public Comment getReview(int reviewId);

	public Comment updateReview(Comment review);

	public Boolean deleteReview(Comment review);

}
