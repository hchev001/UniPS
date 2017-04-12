package com.unips.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.unips.dao.UserReviewDao;
import com.unips.entity.Comment;

@Repository("userReviewDao.mysql")
public class UserReviewDaoMySql implements UserReviewDao {
	
	private static final Logger log = Logger.getLogger(UserReviewDaoMySql.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Comment> getAllReviews(String userName) {
		return null;
	}

	public List<Comment> getAllReviewsForBusiness(String userName, String businessName) {
		return null;
	}

	public Comment addReviewForBusiness(String userName, String businessName) {
		return null;
	}

	public Comment getReview(String userName, Integer reviewId) {
		return null;
	}

	public Comment updateReview(String userName, Integer reviewId) {
		return null;
	}

	public Boolean deleteReview(String userName, Integer reviewId) {
		return null;
	}

}
