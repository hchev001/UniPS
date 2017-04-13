package com.unips.dao.impl;

import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.unips.dao.UserReviewDao;
import com.unips.dao.mapper.CommentRowMapper;
import com.unips.entity.Comment;

@Repository("userReviewDao.mysql")
public class UserReviewDaoMySql implements UserReviewDao {
	
	private static final Logger log = Logger.getLogger(UserReviewDaoMySql.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Comment> getAllReviews(int userId) {
		
		final String sql = "SELECT *  FROM `unipsdb`.`comment` AS c " +
							"WHERE c.user_id=?";
		
		Object[] values = new Object[] {userId};
		int[] types = new int[] {Types.INTEGER};
		
		return jdbcTemplate.query(sql, values, types, new CommentRowMapper());
		
	}
	
	public List<Comment> getAllReviewsForBusiness(int userId, int businessId) {
		final String sql = "SELECT * FROM `unipsdb`.`comment` AS c " +
							"WHERE c.user_id=? AND c.business_id=?";
		
		Object[] values = new Object[] {userId, businessId};
		int[] types = new int[] {Types.INTEGER, Types.INTEGER};
		
		return jdbcTemplate.query(sql, values, types, new CommentRowMapper());
	}

	public Comment addReviewForBusiness(int userId, int businessId) {
		return null;
	}

	public Comment getReview(int userId, int businessId) {
		return null;
	}

	public Comment updateReview(int userId, int businessId) {
		return null;
	}

	public Boolean deleteReview(int userId, int businessId) {
		return null;
	}

}
